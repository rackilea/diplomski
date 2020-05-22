class WeatherReportDisplay
{
    IWeatherServer objserver;

    // Constructor Injection
    WeatherReportDisplay(IWeatherServer server)
    {
        if (server == null) throw new Exception("please send a server");

        this.objServer = server;
    }

    string WeatherReport()
    {
        return objServer.City + " " + objServer.temprature);
    }
}