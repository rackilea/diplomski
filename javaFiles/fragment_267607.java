Use List<Map<String,Object>> for the entry attribute and  put this value in orchestrationFlags json object.

//Refactored code below:    
public static String compileSRF() throws JSONException{

        List<Map<String,Object>> entryList = new ArrayList<>();
        Map<String, Object> flag1 = new HashMap<>();
        flag1.put("key", "overrideStore");
        flag1.put("value", true);
        entryList.add(flag1);

        Map<String, Object> flag2 = new HashMap<>();
        flag2.put("key", "matchmaking");
        flag2.put("value", true);
        entryList.add(flag2);


        JSONObject orchestrationFlags = new JSONObject();
        JSONObject requesterSystem = new JSONObject();
        JSONObject requestedService = new JSONObject();

        orchestrationFlags.put("entry", entryList);

        requesterSystem.put("systemGroup", "testGroup");
        requesterSystem.put("systemName", "testSystem");
        requesterSystem.put("address", "localhost");

        requestedService.put("serviceGroup", "Temperature");
        requestedService.put("serviceDefinition", "IndoorTemperature");
        List<String> interfaces = new ArrayList<String>();
        interfaces.add("json");
        requestedService.put("interfaces", interfaces);

        JSONObject payload = new JSONObject();
        payload.put("requesterSystem", requesterSystem);
        payload.put("requestedService", requestedService);
        payload.put("orchestrationFlags", orchestrationFlags);

        return payload.toString(4);
    }

Output:
{
    "orchestrationFlags": {"entry": [
        {
            "value": true,
            "key": "overrideStore"
        },
        {
            "value": true,
            "key": "matchmaking"
        }
    ]},
    "requesterSystem": {
        "address": "localhost",
        "systemName": "testSystem",
        "systemGroup": "testGroup"
    },
    "requestedService": {
        "interfaces": ["json"],
        "serviceGroup": "Temperature",
        "serviceDefinition": "IndoorTemperature"
    }
}

Hope this helps.