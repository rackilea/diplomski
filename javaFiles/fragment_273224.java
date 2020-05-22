static public class ManageData {
    static Weather weather;
    static public Weather getData(){
        return weather;
    }
    static public void putData(Weather forecast) {
        weather = forecast;

    }
}