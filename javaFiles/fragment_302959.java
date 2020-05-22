public class Data
{
    private String id;

    private String title;

    private String description;

    private Courier courier;

    private String arrival;

    private String departure;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Courier getCourier ()
    {
        return courier;
    }

    public void setCourier (Courier courier)
    {
        this.courier = courier;
    }

    public String getArrival ()
    {
        return arrival;
    }

    public void setArrival (String arrival)
    {
        this.arrival = arrival;
    }

    public String getDeparture ()
    {
        return departure;
    }

    public void setDeparture (String departure)
    {
        this.departure = departure;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", title = "+title+", description = "+description+", courier = "+courier+", arrival = "+arrival+", departure = "+departure+"]";
    }
}