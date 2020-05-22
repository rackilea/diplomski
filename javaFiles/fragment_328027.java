import java.util.*;

class UserBasicInfo{
    String nickName;
    String birthDate;
    String gender;

    public UserBasicInfo(String name,String date,String gender){
        this.nickName = name;
        this.birthDate = date;
        this.gender = gender;        
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name:DOB:Gender:").append(nickName).append(":").append(birthDate).append(":").
        append(gender);
        return sb.toString();
    }
}

class ContactInfo{
    String eMail;
    String mobileHome;
    String mobileWork;

    public ContactInfo(String mail, String homeNo, String mobileOff){
        this.eMail = mail;
        this.mobileHome = homeNo;
        this.mobileWork = mobileOff;
    }    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("email:mobile(H):mobile(W):").append(eMail).append(":").append(mobileHome).append(":").append(mobileWork);
        return sb.toString();
    }
}
class FaceBookUser {
    String userName;
    UserBasicInfo userInfo;
    ContactInfo contactInfo;

    public FaceBookUser(String uName){
        this.userName = uName;
    }    
    public void setUserBasicInfo(UserBasicInfo info){
        this.userInfo = info;
    }
    public void setContactInfo(ContactInfo info){
        this.contactInfo = info;
    }    
    public String getUserName(){
        return userName;
    }
    public UserBasicInfo getUserBasicInfo(){
        return userInfo;
    }
    public ContactInfo getContactInfo(){
        return contactInfo;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("|User|").append(userName).append("|UserInfo|").append(userInfo).append("|ContactInfo|").append(contactInfo);
        return sb.toString();
    }

    static class FaceBookUserBuilder{
        FaceBookUser user;
        public FaceBookUserBuilder(String userName){
            this.user = new FaceBookUser(userName);
        }
        public FaceBookUserBuilder setUserBasicInfo(UserBasicInfo info){
            user.setUserBasicInfo(info);
            return this;
        }
        public FaceBookUserBuilder setContactInfo(ContactInfo info){
            user.setContactInfo(info);
            return this;
        }
        public FaceBookUser build(){
            return user;
        }
    }
}
public class BuilderPattern{
    public static void main(String args[]){
        FaceBookUser fbUser1 = new FaceBookUser.FaceBookUserBuilder("Ravindra").build(); // Mandatory parameters
        UserBasicInfo info = new UserBasicInfo("sunrise","25-May-1975","M");

        // Build User name + Optional Basic Info 
        FaceBookUser fbUser2 = new FaceBookUser.FaceBookUserBuilder("Ravindra").
                                                setUserBasicInfo(info).build();

        // Build User name + Optional Basic Info + Optional Contact Info
        ContactInfo cInfo = new ContactInfo("xxx@xyz.com","1111111111","2222222222");
        FaceBookUser fbUser3 = new FaceBookUser.FaceBookUserBuilder("Ravindra").
                                                setUserBasicInfo(info).
                                                setContactInfo(cInfo).build();

        System.out.println("Facebook user 1:"+fbUser1);
        System.out.println("Facebook user 2:"+fbUser2);
        System.out.println("Facebook user 3:"+fbUser3);
    }
}