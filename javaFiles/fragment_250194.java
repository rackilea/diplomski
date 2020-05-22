import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        Response response = mapper.readValue(jsonFile, Response.class);

        response.getItem().getNextLevel().forEach((k, v) -> {
            System.out.println(k);
            v.getNextLevel().forEach((k1, v1) -> {
                System.out.println("\t" + k1);
                v1.getNextLevel().forEach((k2, v2) -> {
                    System.out.println("\t\t" + k2 + " => " + v2);
                });
            });
        });
    }
}

class Response {

    private boolean success;
    private Item item;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", item=" + item +
                '}';
    }

    public static <T> Map<String, T> getOne(Map<String, Map<String, T>> map) {
        if (map == null || map.size() == 0) {
            return null;
        }

        return map.values().iterator().next();
    }
}

class Item {

    private int id;
    private String outcome;
    private String status;
    private Map<String, SecondLevel> nextLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, SecondLevel> getNextLevel() {
        return nextLevel;
    }

    @JsonAnySetter
    public void set(String property, Map<String, SecondLevel> map) {
        nextLevel = map;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", outcome='" + outcome + '\'' +
                ", status='" + status + '\'' +
                ", firstLevel=" + nextLevel +
                '}';
    }
}

class SecondLevel {

    private Map<String, OutcomeLevel> nextLevel;

    @JsonCreator
    public SecondLevel(Map<String, Map<String, OutcomeLevel>> map) {
        this.nextLevel = Response.getOne(map);
    }

    public Map<String, OutcomeLevel> getNextLevel() {
        return nextLevel;
    }

    @Override
    public String toString() {
        return "SecondLevel{" +
                "nextLevel=" + nextLevel +
                '}';
    }
}

class OutcomeLevel {

    private Map<String, Outcome> nextLevel;

    @JsonCreator
    public OutcomeLevel(Map<String, Map<String, Outcome>> map) {
        this.nextLevel = Response.getOne(map);
    }

    public Map<String, Outcome> getNextLevel() {
        return nextLevel;
    }

    @Override
    public String toString() {
        return "OutcomeLevel{" +
                "nextLevel=" + nextLevel +
                '}';
    }
}

class Outcome {

    private String outcome;
    private String screenshot;
    private int dataRow;

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public int getDataRow() {
        return dataRow;
    }

    public void setDataRow(int dataRow) {
        this.dataRow = dataRow;
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "outcome='" + outcome + '\'' +
                ", screenshot='" + screenshot + '\'' +
                ", dataRow=" + dataRow +
                '}';
    }
}