public MyClass{

    public String name;
    public String contact;
    @JsonUnwrapped
    public PersonalInformation personalinformation;
    //setters and getter here
    }