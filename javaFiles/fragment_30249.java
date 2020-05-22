public class Response
{
    private String country;

    private List<Station> station;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public List<Station> getStation ()
    {
        return station;
    }

    public void setStation (List<station> station)
    {
        this.station = station;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [country = "+country+", station = "+station.toString()+"]";
    }
}