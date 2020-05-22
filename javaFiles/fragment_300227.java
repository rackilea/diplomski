import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

public class Test {

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    Dto dto = getDummy();
    System.out.println(mapper.writeValueAsString(dto));
  }

  @Data
  public static class Dto {
    private String fileName;
    private Integer sfyc;
    private List<Map<String, List<String>>> rect;
  }

  public static Dto getDummy() {
    Dto dto = new Dto();

    dto.setFileName("100055_1_0920_082714_014");
    dto.setSfyc(1);
    List<String> type1List = List.of("1145", "1027", "1954", "1259");// of function for java 9 or newer
    List<String> type2List = List.of("1527", "788", "569", "418");
    List<String> type3List = List.of("4053", "773", "915", "449");
    List<Map<String, List<String>>> maps =
        List.of(
            Map.of("type1", type1List),
            Map.of("type2", type2List),
            Map.of("type1", type3List));
    dto.setRect(maps);
    return dto;
  }
}