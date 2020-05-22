class AttitudeListenerImpl implements AttitudeListener
{
    private int altitude;
    public void setAltitude(int altitude)
    {
        this.altitude = altitude;
    }
    public int getAltitude()
    {
        return this.altitude;
    }
    @Override
    public void attitudeUpdated(float pitch, float roll, float yaw, int altitude) 
    {
        setAltitude(altitude);
        System.out.println("altitude : " + altitude);
    }
}