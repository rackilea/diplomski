import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

class Test {
    public static void main(String[] args) {
        String json = "{\"lv\":[{\"v\":{\"tenureSiteReg\":null,\"bghtItms\":48," +
                "\"pnlValue\":105.478409,\"byrSgmnt\":2,\"cstmrId\":\"814296998\",\"slrRevRnk\":-99.0," +
                "\"soldItms\":0,\"slrSgmnt\":6,\"byrRevRnk\":0.013,\"mainAcct\":78,\"gmv\":0.0," +
                "\"cstmrRevRnk\":0.021,\"pnlRev\":313.438843,\"cstmrSgmnt\":51,\"gmb\":4674.76," +
                "\"totalVal\":142.536293,\"userId\":493},\"cn\":42}],\"lmd\":20130}";
        String id = "493";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(json);
            List<JsonNode> userIds = rootNode.findValues("userId");         
            for (JsonNode node : userIds)
            {
                if (!id.equals(node.toString())) {
                    System.out.println("Log exception: id "+id+" != userId "+node);
                    break;
                } else {
                    System.out.println("Congratulations! id "+id+" = userId "+node);
                }               
            }
        } catch (JsonProcessingException e) {
            System.out.println("JsonProcessingException: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException: ");
            e.printStackTrace();
        }
    }
}