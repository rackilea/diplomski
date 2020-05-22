@Service
public class DataReader {
public BufferedReader ReadDataFrom(string url){
URL url = new URL("http://localhost:8080/endpoint");

HttpURLConnection connection = (HttpURLConnection) url.openConnection();

//Line of importance:
BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
}
}