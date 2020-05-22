class UnitTest
{
    void Should_Return_NewYork_20DegreeBelowZero()
    {
        WeatherReportDisplay obj = new WeatherReportDisplay(new MockServer);
        var result = obj.PrintWeatherReport  ();
        Assert.IsEqual(result, "NewYork_20DegreeBelowZero");
    }
}