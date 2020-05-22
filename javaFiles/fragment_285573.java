import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonSerialize(using=CompanySerilizable.class)
public class SignUpVO {
    private String email;
    private Integer regNumber;
    private String companyName;
    private String dob;
    private String type;
    private String password;
    private String confirmPassword;
    private AddressVO address;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getRegNumber() {
        return regNumber;
    }
    public void setRegNumber(Integer regNumber) {
        this.regNumber = regNumber;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public AddressVO getAddress() {
        return address;
    }
    public void setAddress(AddressVO address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "SignUpVO [email=" + email + ", regNumber=" + regNumber + ", companyName=" + companyName + ", dob=" + dob
                + ", type=" + type + ", address=" + address + "]";
    }
}