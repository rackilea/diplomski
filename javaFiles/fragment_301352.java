public class Contact {

    @SerializedName("address")
    private Address mAddress;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("name")
    private String mName;

    // getters and setters...

}

public class Address {

    @SerializedName("number")
    private Long mNumber;
    @SerializedName("street")
    private String mStreet;

    // getters and setters...

}