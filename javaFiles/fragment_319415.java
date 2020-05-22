import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
public class Customer {

    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    @JsonDeserialize(using = WhiteSpaceTrimmerDeserializer.class)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}