package com.iglooworks.test;

import com.iglooworks.tools.JsonSorter;
import org.json.simple.*;

public class Test {
    public static void main(String[] args) {
                String json = "[\n" +
                "   {\n" +
                "      \"firstName\":\"John\",\n" +
                "      \"lastName\":\"Doe\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"firstName\":\"Anna\",\n" +
                "      \"lastName\":\"Smith\"\n" +
                "   },\n" +
                "   {\n" +
                "      \"firstName\":\"Peter\",\n" +
                "      \"lastName\":\"Jones\"\n" +
                "   }\n" +
                "]";

        JSONArray jsonArray;
        try {
            jsonArray = tools.sortJsonByKey((JSONArray) JSONValue.parse(json), "firstName");


            for (Object o : jsonArray) {
                JSONObject tmp = (JSONObject) o;
                System.out.println(tmp.get("firstName") + " - " + tmp.get("lastName"));
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        }


    }
}