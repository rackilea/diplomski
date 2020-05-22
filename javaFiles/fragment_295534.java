import org.json.JSONException;

import org.json.JSONObject;

import java.util.*;

public class sample {
private static class MyModel {
    String key;
    int value;

    MyModel(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public static void main(String[] args) {
    List<MyModel> list = new ArrayList<>();

    try {
        //here is you json object
        JSONObject obj = new JSONObject();
        obj.put("name1", 29);
        obj.put("name2", 26);
        obj.put("name3", 29);
        obj.put("name4", 27);

        //parsing your json
        Iterator<?> keys = obj.keys();
        MyModel objnew;
        while (keys.hasNext()) {
            String key = (String) keys.next();
            objnew = new MyModel(key, obj.optInt(key));
            list.add(objnew);
        }

        //sorting the values
        Collections.sort(list, new Comparator<MyModel>() {
            @Override
            public int compare(MyModel o1, MyModel o2) {
                return Integer.compare(o2.value, o1.value);
            }
        });
        //print out put
        for (MyModel m : list) {
            System.out.println(m.key + " : " + m.value);
        }

    } catch (JSONException e) {
        e.printStackTrace();
    }
}