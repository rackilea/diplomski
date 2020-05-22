public class Member {
    private final String firstname;
    private final String lastname;

    @JsonCreator
    public Member(@JsonProperty("firstname") String firstname, 
                  @JsonProperty("lastname") String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

   ....

}