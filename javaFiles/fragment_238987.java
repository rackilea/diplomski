import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

ObjectMapper om = new ObjectMapper();
JsonNode tree = om.readTree(jsonString);
JsonNode dtoNode = tree.get(0);
SummonerDto dto = om.readValue(om.treeAsTokens(dtoNode), SummonerDto.class);