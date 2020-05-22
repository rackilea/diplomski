public class User {

    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("email_address")
    @Expose
    private String emailAddress;
    @SerializedName("end_date")
    @Expose
    private Object endDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }
}