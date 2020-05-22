import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

public class ProfileApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(new Profile()));
    }
}

class ProfileJsonSerialize extends JsonSerializer<Profile> {

    @Override
    public void serialize(Profile profile, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        if (!profile.isNameSecret()) {
            gen.writeStringField("firstName", profile.getFirstName());
            gen.writeStringField("lastName", profile.getLastName());
        }
        gen.writeStringField("nickName", profile.getNickName());
        gen.writeEndObject();
    }
}

@JsonSerialize(using = ProfileJsonSerialize.class)
class Profile {

    private String firstName = "Rick";
    private String lastName = "Sanchez";
    private String nickName = "Pickle Rick";
    private boolean isNameSecret = true;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isNameSecret() {
        return isNameSecret;
    }

    public void setNameSecret(boolean nameSecret) {
        isNameSecret = nameSecret;
    }
}