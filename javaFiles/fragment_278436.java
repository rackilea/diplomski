import org.json.JSONObject;
import org.json.XML;

public class example {

public static void main(String[] args) {
    JSONObject json = new JSONObject(getJSONSting() );
    String xml = XML.toString(json);
    System.out.println(xml);
}

private static final String getJSONSting() {
    String data = "{\"Engineering\":{ \"Electrical Engineering\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Non-tenure-track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"], \"Professional Staff\":[\"business manager\",\"university research administrator\",\"department administrative assistant\"]},";
           data += "\"Computer Science\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"]}, \"Computer Engineering\":{\"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Professional Staff\":[\"business manager\",\"university research administrator\",\"department administrative assistant\"]}";
           data += "},";
           data += "\"Science\":{ \"Physics\":{ \"Research Staff\":[\"research associate\",\"research sciencetist\",\"senior research sciencetist\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Non-Tenured-Track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"]},";
           data += "\"Chemistry\":{ \"Tenured\":[\"distinguished professor\",\"professor\",\"associate professor\",\"assistant professor\"], \"Teaching Faculty\":[\"lecturer\",\"senior lecturer\",\"adjunct professor\"], \"Non-Tenured-Track\":[\"research professaor\",\"associate research professor\",\"assistant research profesor\",\"clinical profesor\",\"clinical associate profesor\",\"clinical assistant profesor\",\"visiting profesor\",\"visiting associate profesor\",\"visiting assistant profesor\"]}";
           data += "}";
           data += "}";
        return data;
    }
}