import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        DetailDto[] values = new ObjectMapper().readerFor(DetailDto[].class)
                .readValue(Main.class.getResourceAsStream("data.json"));
//      for (DetailDto dto : values) {
//          display(dto);
//      }

        Map<Key, IntSummaryStatistics> res = Stream.of(values)
                .collect(Collectors.groupingBy(DetailDto::key, Collectors.summarizingInt(DetailDto::getPrice)));

        Stream<DetailDto> agg = res.entrySet().stream().map(e -> new DetailDto(e.getKey().category1,
                e.getKey().category2, e.getKey().price, (int) e.getValue().getSum()));

        agg.forEach(Main::display);

    }

    protected static void display(DetailDto dto) {
        final ObjectWriter json = new ObjectMapper().writerFor(DetailDto.class).withDefaultPrettyPrinter();
        try {
            System.out.println(json.writeValueAsString(dto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}