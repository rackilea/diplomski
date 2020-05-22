class Person
{
    @SerializedName("name")
    String name;

    @SerializedName("surname")
    String surname;

    @SerializedName("location")
    Location location;  // new Location(String name, String desc)
}