String json = "{" +
            "\"tableID\": 1," +
            "\"price\": 53," +
            "\"payment\": \"cash\"," +
            "\"quantity\": 3," +
            "\"products\": [";

for (int i = 0; i < 100; i++) {
    json += "{ \"ID\": 3, \"quantity\": 2 }";
    if(i != 100) json += ",";    
}

json += "]}";