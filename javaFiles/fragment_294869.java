import java.util.Scanner;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class JSONMessageHandler {
    void handleInput(JSONArray list)
    {
        System.out.println(
                "handleInput():  got a JSONArray (list) containing " +
                    list.size() + " elements");

        for (Object o : list)
            System.out.println(o);
    }

    void handleInput(JSONObject map)
    {
        System.out.println(
                "handleInput():  got a JSONObject (map) containing " +
                    map.size() + " items");

        for (Iterator it = map.keySet().iterator(); it.hasNext();)
        {
            Object key = it.next();
            System.out.println(key + ": " + map.get(key));
        }
    }
}


class Hi {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        Object obj = new JSONParser().parse(in.nextLine());
        JSONMessageHandler msgHandler = new JSONMessageHandler();

        if (obj instanceof JSONArray)
            msgHandler.handleInput((JSONArray)obj);
        else if (obj instanceof JSONObject)
            msgHandler.handleInput((JSONObject)obj);
    }
}