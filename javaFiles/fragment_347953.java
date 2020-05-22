@Data
public class Results
{
    private int uniqueCount;

    // all unknown properties will go here
    @JsonAnySetter
    public void setUnknownProperty(String key, Object value) {
        if (key.equals("count")) {
            uniqueCount = (Integer)value;
        }
    }
}