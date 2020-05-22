public class Weather {

    public static void main(String[] args) {


    String API_KEY = "8984d739fa91d7031fff0e84a3d2c520";
    String Location = "Brooklyn";
    String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + Location
            + "&appid=" + API_KEY + "&units=imperial";

    try {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null){
            result.append(line);
        }
        rd.close();
        System.out.println(result);
        com.google.gson.Gson gson=new Gson();
        Example finalResult=gson.fromJson(result.toString() , Example.class);
        System.out.println(finalResult.getMain().getTemp()); //56.26
        System.out.println(finalResult.getMain().getHumidity());  // 54
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}