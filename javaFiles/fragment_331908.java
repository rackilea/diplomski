package test;

import org.json.simple.*;

public class JSONTest {

    public void testMethod(){
        JSONObject obj = new JSONObject();
        obj.put("name","test");

        JSONArray list = new JSONArray();
        list.add("1234");
    }

    public static void main(String [] args){
        JSONObject obj = new JSONObject();
        obj.put("name","test");

        JSONArray list = new JSONArray();
        list.add("1234");
    }
}