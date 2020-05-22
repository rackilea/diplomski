Type type = new TypeToken< HashMap<String, HashMap<String, ArrayList<com.google.gson.internal.LinkedTreeMap>>>>() {}.getType();

HashMap<String, HashMap<String, ArrayList<com.google.gson.internal.LinkedTreeMap>>> hashMap = new Gson().fromJson(API.getJSON(), type);    

com.google.gson.internal.LinkedTreeMap hash = hashMap.get("data").get("current_condition").get(0);

System.out.println("    "+hash.get("humidity")+"      ");