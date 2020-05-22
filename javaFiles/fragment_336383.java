import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDateTime;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        String[] jsons = {
                "{\"number\":1,\"date\":\"2019-01-01T22:23:11\",\"max_amount\":4.9}",
                "{\"number\":null,\"date\":null,\"max_amount\":null}",
                "{}",
                "{\"number\":1}",
                "{\"date\":\"2019-01-01T22:23:11\"}",
                "{\"max_amount\":4.9}",
                "{\"number\":1,\"date\":null,\"max_amount\":null}"
        };
        for (String json : jsons) {
            System.out.println(json + " => " + mapper.readValue(json, Pojo.class));
        }
    }
}

class Pojo {

    private static final LocalDateTime NULL_DATE = LocalDateTime.of(1900, 1, 1, 12, 13);

    @JsonProperty("max_amount")
    private Double maxAmount = Double.MIN_VALUE;
    private Integer number = Integer.MIN_VALUE;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime date = NULL_DATE;

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "number=" + number +
                ", date=" + date +
                ", maxAmount=" + maxAmount +
                '}';
    }
}