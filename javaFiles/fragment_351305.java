public class Predefined
{
    @NotNull
    @Size(min = 1, max = 25)
    public UUID phone;

    @NotNull
    @Size(min = 1, max = 40)
    public UUID company;

    public Predefined(UUID phone, UUID company)
    {
        this.phone = phone;
        this.company = company;
    }
}