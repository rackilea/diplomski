package com.mypackage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonStr = "{\"status\": \"OK\",\"origin_addresses\": [ \"Vancouver, BC, Canada\", \"Seattle, État de Washington, États-Unis\" ],\"destination_addresses\": [ \"San Francisco, Californie, États-Unis\", \"Victoria, BC, Canada\" ],\"rows\": [ {\"elements\": [ {\"status\": \"OK\",\"duration\": {\"value\": 340110,\"text\": \"3 jours 22 heures\"},\"distance\": {\"value\": 1734542,\"text\": \"1 735 km\"}}, {\"status\": \"OK\",\"duration\": {\"value\": 24487,\"text\": \"6 heures 48 minutes\"},\"distance\": {\"value\": 129324,\"text\": \"129 km\"}} ]}, {\"elements\": [ {\"status\": \"OK\",\"duration\": {\"value\": 288834,\"text\": \"3 jours 8 heures\"},\"distance\": {\"value\": 1489604,\"text\": \"1 490 km\"}}, {\"status\": \"OK\",\"duration\": {\"value\": 14388,\"text\": \"4 heures 0 minutes\"},\"distance\": {\"value\": 135822,\"text\": \"136 km\"}} ]} ]}";

        try {
            JSONObject rootObject = new JSONObject(jsonStr); // Parse the JSON to a JSONObject
            JSONArray rows = rootObject.getJSONArray("rows"); // Get all JSONArray rows

            for(int i=0; i < rows.length(); i++) { // Loop over each each row
                JSONObject row = rows.getJSONObject(i); // Get row object
                JSONArray elements = row.getJSONArray("elements"); // Get all elements for each row as an array

                for(int j=0; j < elements.length(); j++) { // Iterate each element in the elements array
                    JSONObject element =  elements.getJSONObject(j); // Get the element object
                    JSONObject duration = element.getJSONObject("duration"); // Get duration sub object
                    JSONObject distance = element.getJSONObject("distance"); // Get distance sub object

                    System.out.println("Duration: " + duration.getInt("value")); // Print int value
                    System.out.println("Distance: " + distance.getInt("value")); // Print int value
                }
            }
        } catch (JSONException e) {
            // JSON Parsing error
            e.printStackTrace();
        }
    }
}