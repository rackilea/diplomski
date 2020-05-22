public class MyEntity {
    @JsonProperty("MYSpecialSuperId")
    private String mySpecialSuperId;

    ...

    public String getMySpecialSuperId() {
        return this.mySpecialSuperId;
    }

}