import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main Lambda class to receive event stream, parse it to Survey
 * and process them.
 */
public class SurveyEventProcessor implements
        RequestHandler<DynamodbEvent, String> {

    private static final String INSERT = "INSERT";

    private static final String MODIFY = "MODIFY";

    public String handleRequest(DynamodbEvent ddbEvent, Context context) {

        List<Item> listOfItem = new ArrayList<>();
        List<Map<String, AttributeValue>> listOfMaps = null;
        for (DynamodbStreamRecord record : ddbEvent.getRecords()) {

            if (INSERT.equals(record.getEventName()) || MODIFY.equals(record.getEventName())) {
                listOfMaps = new ArrayList<Map<String, AttributeValue>>();
                listOfMaps.add(record.getDynamodb().getNewImage());
                listOfItem = InternalUtils.toItemList(listOfMaps);
            }

            System.out.println(listOfItem);
            try {
               // String json = new ObjectMapper().writeValueAsString(listOfItem.get(0));
                Gson gson = new Gson();
                Item item = listOfItem.get(0);

                String json = gson.toJson(item.asMap());
                System.out.println("JSON is ");
                System.out.println(json);
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        return "Successfully processed " + ddbEvent.getRecords().size() + " records.";
    }
}