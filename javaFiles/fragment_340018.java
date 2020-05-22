class Location
{
    private String id = null;
    private double latitude = 0.0;
    private double longitude = 0.0;

    public Location(String id, double latitude, double longitude)
    {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude
    }

    public double getLatitude()
    {
        return longitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }
}