import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class CompanySerilizable extends JsonSerializer<SignUpVO> {

    @Override
    public void serialize(SignUpVO sign, JsonGenerator json, SerializerProvider sprov)
            throws IOException, JsonProcessingException {
        json.writeStartObject();
        json.writeNumberField("regNumber", sign.getRegNumber());
        json.writeStringField("line1", sign.getAddress().getLine1());
        json.writeStringField("companyName", sign.getCompanyName());
        json.writeStringField("dob", sign.getDob());
        json.writeStringField("line2", sign.getAddress().getLine2());
        json.writeStringField("country", sign.getAddress().getCountry());
        json.writeStringField("state", sign.getAddress().getState());
        json.writeNumberField("zipCode", sign.getAddress().getZipCode());
        json.writeStringField("password", sign.getPassword());
        json.writeStringField("confirmPassword", sign.getConfirmPassword());
        json.writeStringField("email", sign.getEmail());
        json.writeStringField("type", sign.getType());
        json.writeEndObject();

    }

}