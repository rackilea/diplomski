import com.google.gson.annotations.SerializedName;

public class Fields {
    private String signature;
    private String AWSAccessKeyId;

    @SerializedName("x-amz-security-token")
    private String x_amz_security_token;

    private String key;
    private String policy;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAWSAccessKeyId() {
        return AWSAccessKeyId;
    }

    public void setAWSAccessKeyId(String aWSAccessKeyId) {
        AWSAccessKeyId = aWSAccessKeyId;
    }

    public String getX_amz_security_token() {
        return x_amz_security_token;
    }

    public void setX_amz_security_token(String x_amz_security_token) {
        this.x_amz_security_token = x_amz_security_token;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

}