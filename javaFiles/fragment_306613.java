import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import java.util.ArrayList;
import java.util.List;

public class PopulateNestedAvroObjects {
    public static void main(String [] args ){
        String strSchema = "{\n" +
                "    \"name\": \"AgentRecommendationList\",\n" +
                "    \"type\": \"record\",\n" +
                "    \"fields\": [\n" +
                "        {\n" +
                "            \"name\": \"userid\",\n" +
                "            \"type\": \"string\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"friends\",\n" +
                "            \"type\": {\n" +
                "                \"type\": \"array\",\n" +
                "                \"items\": {\n" +
                "                    \"name\": \"SchoolFriends\",\n" +
                "                    \"type\": \"record\",\n" +
                "                    \"fields\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Name\",\n" +
                "                            \"type\": \"string\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"phoneNumber\",\n" +
                "                            \"type\": \"string\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"name\": \"email\",\n" +
                "                            \"type\": \"string\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        Schema schema = new Schema.Parser().parse(strSchema);
        GenericRecord record = new GenericData.Record(schema);
        record.put("userid", "test user");
        Schema childSchema = record.getSchema().getField("friends").schema().getElementType();
        List<GenericRecord> friendList = new ArrayList();
        GenericRecord friend1 = new GenericData.Record(childSchema);
        friend1.put("Name", "1");
        friend1.put("phoneNumber", "2");
        friend1.put("email", "3");
        friendList.add(friend1);
        record.put("friends", friendList);
        System.out.println(record);


    }
}