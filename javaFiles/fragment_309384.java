final JSONParser parser = new JSONParser();
final File file = new File("/Users/amzadhossain/Documents/jsonfile2.json");
final FileReader reader = new FileReader(file);
final JSONObject jsonObject = (JSONObject) parser.parse(reader);
final JSONArray languages = (JSONArray) jsonObject.get("languages");
List<Map<String, String>> lstmap = new ArrayList<Map<String, String>>();
        Iterator<String> iter = null;
        for (int i = 0; i < languages.size(); i++) {
            JSONObject firstarr = (JSONObject) languages.get(i);
            iter = firstarr.keySet().iterator();            
            while(iter.hasNext()){
                final Map<String, String> map = new HashMap<String, String>();
                String key = (String)iter.next();
                Object value = firstarr.get(key); 
                map.put(key, value.toString());
                lstmap.add(map);
               System.out.println("key is "+key + " and value is " + value);
            }

        }
        for (Map<String, String> map : lstmap){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
            }
        }