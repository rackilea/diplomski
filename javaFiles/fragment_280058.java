public class Country
{
    private final String name;
    private final String code;

    public Country(String name, String code)
    {
        this.name = name;
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public String getCode()
    {
        return code;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Country country = (Country) obj;

        return code.equals(country.code);
    }

    public int hashCode()
    {
        return code.hashCode();
    }
}