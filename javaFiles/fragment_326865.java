JsonParser parser = new JsonParser();
JsonObject rootObj = parser.parse(jsonString).getAsJsonObject();    
String element21121 = rootObj
                       .getAsJsonObject("mainDocument")
                       .getAsJsonObject("element2")
                       .getAsJsonObject("element21")
                       .getAsJsonObject("element211")
                       .getAsJsonObject("element2112")
                       .getAsString("element21121");