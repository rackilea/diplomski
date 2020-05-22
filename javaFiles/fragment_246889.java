package com.example.pbp22.dogbreed;

import android.text.TextUtils;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QueryUtils {

    /** Tag for the log messages */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    /**
     * Query the dataset and return a list of {@link Breed} objects.
     * @param breedNames
     */
    public static List<Breed> fetchBreedData(List<String> breedNames) {

        // Perform HTTP request to the URL and receive a JSON response back
        List<String> jsonResponse = readImageUrl(breedNames);

        // Extract relevant fields from the JSON response and create a list of {@link Breed}s
        List<Breed> breeds = extractBreedFromJson(jsonResponse, breedNames);

        // Return the list of {@link Breed}s
        return breeds;
    }

    /**
     * Query the dataset and return a list of {@link Breed} objects.
     */
    public static List<String> fetchBreedNameData() {

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = readBreedNameUrl();

        // Extract relevant fields from the JSON response and create a list of {@link Breed}s
        List<String> breedNames = extractBreedNameFromJson(jsonResponse);

        // Return the list of {@link Breed}s
        return breedNames;
    }

    private static List<String> readImageUrl(List<String> breedNames) {

        List<String> reponses = new ArrayList<>();

        for (String breed : breedNames) {
            StringBuilder content = new StringBuilder();
            try {
                // create a url object
                URL url = new URL(String.format("https://dog.ceo/api/breed/%s/images/random", breed));
                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();
                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            reponses.add(content.toString());
        }

        return reponses;
    }

    /**
     * Return a list of {@link Breed} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<Breed> extractBreedFromJson(List<String> responses, List<String> breedNames) {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(responses.toString())) {
            return null;
        }

        // Create an empty ArrayList that we can start adding breeds to
        List<Breed> breeds = new ArrayList<>();

        for (int i = 0; i < responses.size(); i++) {

            try {

                // Create a JSONObject from the JSON response string
                JSONObject baseJsonResponse = new JSONObject(responses.get(i));

                String image = baseJsonResponse.getString("message");

                String breedName = breedNames.get(i);

                breeds.add(new Breed(image, breedName));

            } catch (JSONException e) {
                // If an error is thrown when executing any of the above statements in the "try" block,
                // catch the exception here, so the app doesn't crash. Print a log message
                // with the message from the exception.
                Log.e("QueryUtils", "Problem parsing the JSON results", e);
            }


        }

        // Return the list of breeds
        return breeds;
    }

    private static String readBreedNameUrl() {

            StringBuilder content = new StringBuilder();
            try {
                // create a url object
                URL url = new URL("https://dog.ceo/api/breeds/list/all");
                // create a urlconnection object
                URLConnection urlConnection = url.openConnection();
                // wrap the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // read from the urlconnection via the bufferedreader
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        return content.toString();
    }

    /**
     * Return a list of {@link String} objects (breed names) that has been built up from
     * parsing the given JSON response.
     */
    private static List<String> extractBreedNameFromJson(String responses) {

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(responses)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding breed names to
        List<String> breedNameList = new ArrayList<>();


            try {
                JSONObject jsonObject = new JSONObject(responses);
                JSONObject messageObj = jsonObject.getJSONObject("message");

                for (Iterator<String> iter = messageObj.keys(); iter.hasNext(); ) {
                    String key = iter.next();
                    Log.w("key", key);
                    breedNameList.add(key);
                }

                Log.w("messageObj", messageObj.toString());

            } catch (JSONException e) {
                // If an error is thrown when executing any of the above statements in the "try" block,
                // catch the exception here, so the app doesn't crash. Print a log message
                // with the message from the exception.
                Log.e("QueryUtils", "Problem parsing the JSON results", e);
            }

        // Return the list of breeds
        return breedNameList;
    }

}