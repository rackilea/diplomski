//private variables

    String email_id;
    String mobile_number;
    String password;




    // Empty constructor
    public UserRegister(){}

    // constructor
    public UserRegister( String email_id,String mobile_number, String password){
    this.email_id=email_id;
    this.mobile_number=mobile_number;
    this.password = password;
    }

    public String getEmailId() {
    return email_id;
    }

    public void setEmailId(String email_id){
    this.email_id = email_id;
    }

    public String getMobNo() {
    // TODO Auto-generated method stub
    return mobile_number;
    }

    public void setMobNo(String mobile_number){
    this.mobile_number=mobile_number;
    }

public String getPassword() {
    return password;
    }

public void setPassword(String password) {
    this.password = password;
    }