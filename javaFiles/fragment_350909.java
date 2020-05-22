public class Main {

public static void main(String[] args) {
    JSONObject obj = JSONUtils.getJSONObjectFromFile("/15s_60bpm_ecg_data.json");
    String[] names = JSONObject.getNames(obj); 
    for(String string : names) {
        //System.out.println(string); 
        //System.out.println(string + ":" + obj.get(string)); 
    }

    JSONArray jsonArray = obj.getJSONArray("I");
    CargarArray(jsonArray);
    for(int i = 0; i < jsonArray.length(); i++) {
        //System.out.println(jsonArray.get(i)); 
    }
}


public static void CargarArray(JSONArray jsonArray){
    ArrayList<Integer> Lista = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            try {
                JSONObject json = jsonArray.getJSONObject(i);
                Lista.add(json.getInt("value"));

            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
       for (int j = 0; j < Lista.size(); j++) {

            System.out.println(Lista.get(j));
      }
}

}