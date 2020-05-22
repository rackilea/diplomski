import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;

class UserDeserialiser extends JsonDeserializer<User>
{
    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException
    {
        System.out.println("Deserializing User...");

        ObjectNode node = jp.getCodec().readTree(jp);

        User user = new User();
        user.setFirstName(node.get("firstName").asText());
        user.setLastName(node.get("lastName").asText());

        JsonNode addressNode = node.get("address");
        if (addressNode != null)
        {
            JsonParser parser = addressNode.traverse();
            parser.setCodec(jp.getCodec());
            Address address = parser.readValueAs(Address.class);
            user.setAddress(address);
        }
        return user;
    }
}

class AddressDeserialiser extends JsonDeserializer<Address>
{
    @Override
    public Address deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException
    {
        System.out.println("Deserializing Address...");

        ObjectNode node = jp.getCodec().readTree(jp);

        Address address = new Address();
        address.setStreetName(node.get("streetName").asText());
        address.setPostCode(node.get("postCode").asText());

        JsonNode addressTypeNode = node.get("addressType");
        if (addressTypeNode != null)
        {
            JsonParser parser = addressTypeNode.traverse();
            parser.setCodec(jp.getCodec());
            Address.AddressType addressType = 
                parser.readValueAs(Address.AddressType.class);
            address.setAddressType(addressType);
        }
        return address;
    }
}

public class NestedDeserializers
{
    public static void main(String[] args) throws IOException
    {

        User user = new User();
        user.setFirstName("A");
        user.setLastName("B");

        Address address = new Address();
        address.setStreetName("C");
        address.setPostCode("D");
        address.setAddressType(Address.AddressType.X);
        user.setAddress(address);

        ObjectMapper mapper = createObjectMapper();
        String jsonString = mapper.writeValueAsString(user);
        System.out.println("JSON string representation:\n" + jsonString);

        User readUser = mapper.readValue(jsonString, User.class);

        System.out.println("User     : " + user);
        System.out.println("Read user: " + readUser);
    }

    private static ObjectMapper createObjectMapper()
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserialiser());
        module.addDeserializer(Address.class, new AddressDeserialiser());
        mapper.registerModule(module);
        return mapper;
    }

}


//=============================================================================
// Dummy User/Address classes below

class User
{
    private String firstName;
    private String lastName;
    private Address address;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "User [firstName=" + getFirstName() + ", lastName="
            + getLastName() + ", address=" + getAddress() + "]";
    }

}

class Address
{
    enum AddressType
    {
            X, Y;
    }

    private String streetName;
    private String postCode;
    private AddressType addressType;

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public AddressType getAddressType()
    {
        return addressType;
    }

    public void setAddressType(AddressType addressType)
    {
        this.addressType = addressType;
    }

    @Override
    public String toString()
    {
        return "Address [streetName=" + getStreetName() + ", postCode="
            + getPostCode() + ", addressType=" + getAddressType() + "]";
    }

}