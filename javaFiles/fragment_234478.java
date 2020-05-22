import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @JsonProperty("id_hash")
    public Integer idHash;
    @JsonProperty("user_name")
    public String userName;
    @JsonProperty("user_surname")
    public String userSurname;
    @JsonProperty("birthdate")
    @JsonDeserialize(using = BirthdayDeserializer.class)
    public Date birthdate;
    @JsonProperty("height")
    public Integer height;
    @JsonProperty("weight")
    public Integer weight;
    @JsonProperty("sex")
    public Integer sex;
    @JsonProperty("photo_path")
    public String photoPath;

}