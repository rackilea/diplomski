import play.libs.WS;
import play.*;
import play.mvc.*;
import play.mvc.Result.*;
import play.libs.F.Promise;
import play.libs.F.Function;

import java.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class Order {

...

    public static List<Order> getOrders() {
        String hostUri = Helper.getWsHostUri();

        Promise<WS.Response> promise = WS.url(hostUri + "Orders").get();
        Promise<List<Order>> promisedResult = promise.map(
            new Function<WS.Response, List<Order>>() {
                public List<Order> apply(WS.Response response) {
                    JsonNode json = response.asJson();
                    ArrayNode results = (ArrayNode)json;

                    List<Order> orders = new ArrayList<Order>();
                    Iterator<JsonNode> it = results.iterator();

                    while (it.hasNext()) {
                        JsonNode node  = it.next();
                        Order order = new Order();

                        order.from = node.get("From").asText();
                        order.contact = node.get("Contact").asText();
                        order.amount = node.get("Amount").asDouble();
                        order.status = node.get("Status").asInt();

                        orders.add(order);
                    }

                    return orders;
                }
            }
        );

        return promisedResult.get();
    }
}