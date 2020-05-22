@Component
public class ConfigClass {

    // @Value("${bws.access.key:<no-value>}")  // <- you can use it this way if you want a default value if the property is not found
    @Value("${bws.access.key}")                // <- Notice how the property is being bind here and not upon the method `setAccessKey`
    private String accessKey;

    // optional, in case you need to change the value of `accessKey` later
    public void setAccessKey(String ak){
        this.accessKey = ak;
    }

    public String getAccessKey() {
        return this.accessKey;
    }

}