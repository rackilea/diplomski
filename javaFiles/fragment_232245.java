//String apiResponse = get Api Response
JsonParser parser = new JsonParser();    // parser converstthe api response to Json
JsonObject obj = (JsonObject) parser.parse(apiResponse);
JsonObject obj1 = obj.getAsJsonObject("dataset");
JsonArray arr = obj1.get("data").getAsJsonArray();

String[][] newString = new String[arr.size()][arr.get(0).getAsJsonArray().size()];

for(int i=0;i<newString.length;i++) {

            for(int j=0;j<newString[i].length;j++) {


                newString[i][j] = arr.get(i).getAsJsonArray().get(j).getAsString();

            }

        }


System.out.println(Arrays.deepToString(newString));