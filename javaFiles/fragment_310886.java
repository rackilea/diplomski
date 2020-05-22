package com.iglooworks.test;
    import org.json.simple.JSONArray;
    import org.json.simple.JSONObject;

    import java.util.Set;
    import java.util.SortedMap;
    import java.util.TreeMap;

    public class JsonSorter {
        public static JSONArray sortJsonByKey(JSONArray json, String key)
        {
            JSONArray sorted = new JSONArray();
            SortedMap map = new TreeMap();

            for (Object o : json) {
                JSONObject tmp = (JSONObject) o;
                map.put(tmp.get(key),tmp);
            }

            Set<String> numbers = map.keySet();

            for (String number : numbers) {
                sorted.add(map.get(number));
            }

            return sorted;
        }

}