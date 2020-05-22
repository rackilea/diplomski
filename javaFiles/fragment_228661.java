public class PopulationService {

  public static void getPopulation() {
    String query_url =
        "https://data.opendatasoft.com/api/records/1.0/search/?dataset=world-population@kapsarc&facet=country_name&facet=year&refine.country_name=Australia&refine.year=2000";

    try {
      URL url = new URL(query_url);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.connect();

      BufferedReader br = new BufferedReader(new InputStreamReader(
              (conn.getInputStream())));
      String output;
      System.out.println("Response Server .... \n");
      while ((output = br.readLine()) != null) {
        System.out.println(output);
      }
      conn.disconnect();

      int status = conn.getResponseCode();
      System.out.println("Status Code: "+status);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String args[]) {
    getPopulation();
  }
}