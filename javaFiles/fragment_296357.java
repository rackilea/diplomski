public class Person {
    @Expose @SerializedName("NAME")
    public String name;
    @Expose @SerializedName("AGE")
    public String age; // because your snippet showed "18" in quotes

    // getters and setters, if you like
}