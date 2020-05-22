import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        XmlMapper xmlMapper = new XmlMapper();
        System.out.println(xmlMapper.readValue(xmlFile, Result.class));
    }
}

class Result {

    private Map<String, String> entries = new HashMap<>();
    private LocalDate precedingDate;

    public Map<String, String> getEntries() {
        return entries;
    }

    public LocalDate getPrecedingDate() {
        return precedingDate;
    }

    @JsonAnySetter
    public void setEntry(String key, Object value) {
        if ("PrecedingDate".equals(key)) {
            Map<String, String> date = (Map<String, String>)((Map) value).get("Date");
            precedingDate = LocalDate.of(
                    Integer.parseInt(date.get("year")),
                    Integer.parseInt(date.get("month")),
                    Integer.parseInt(date.get("day")));
        } else {
            entries.put(key, value.toString());
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "entries=" + entries +
                ", precedingDate=" + precedingDate +
                '}';
    }
}