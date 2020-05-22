public class PublicInformation
{
    public String username;
    public String status;
}

public class PrivateInformation extends PublicInformation
{
    public String somePrivateInformation;

    public PublicInformation prepareToSend(){
        return new PublicInformation(){username = this.username, status = this.status};
    }
}