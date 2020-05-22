public class UserOutDTO {
    @Expose
    @SerializedName("User id")
    private int id; 
    @Expose
    private String firstName; 
    @Expose
    private String lastName;

    /*
     * This field will become available for all requests coming for version 2.0 onwards. For a request before 
     * version 2.0 the address field won't be available.
     */
    @Expose
    @Since(2.0)
    private String address; 

    /*
     * This field will become available after version 3.0 an example when you extend your model
     */
    @Expose
    @Until(3.0) 
    private String nickname; 

    //Getters and Setters
}