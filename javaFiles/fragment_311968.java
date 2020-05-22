class WeatherReportDisplay
{
    WeatherServerSomeWhereInIowa objserver = new WeatherServerSomeWhereInIowa();

    void PrintWeatherReport()
    {
        foreach (var item in objserver.Weather.Items)
        {
            Println(item.City + " " + item.temprature);
        }
    }
}