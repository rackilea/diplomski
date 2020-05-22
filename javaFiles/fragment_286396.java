package stackoverflow.questions;

import java.util.List;

import com.google.gson.Gson;

public class Question {

    class Record {
        Long timestamp;
        String deviceId;
        Long temperature;
    }

    class Container {
        List<Record> records;
    }

    public static void main(String[] args) {
        String json = "{ \"status\": \"success\", \"records\": [{\"timestamp\": 1381222871868,\"deviceId\": \"288\",\"temperature\": 17 },{\"timestamp\": 1381222901868,\"deviceId\": \"288\",\"temperature\": 17 },{\"timestamp\": 1381222931868,\"deviceId\": \"288\",\"temperature\": 17 } ]} ";

        Gson g = new Gson();
        Container c = g.fromJson(json, Container.class);
        for (Record r : c.records)
            System.out.println(r);

    }
}