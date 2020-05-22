import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

static String test = "{\n  \"status\": \"success\",\n  \"message\": \"Request Successfull\",\n  \"messagetitle\": \"Success\",\n  \"show\": \"false\",\n  \"goback\": \"false\",\n  \"marriages\": [\n    {\n      \"marriagenum\": \"8\",\n      \"marriage_from\": \"2015-09-04\",\n      \"marriage_to\": \"2015-09-04\",\n      \"planner\": {\n        \"id\": \"9\",\n        \"fbid\": \"67656767676767\",\n        \"name\": \"dsds sd\",\n        \"imageurl\": \"https:\\/\\/graph.facebook.com\\/545435544334423243\\/picture?type=large\"\n      },\n      \"groom\": {\n        \"id\": \"1\",\n        \"fbid\": \"4333334344343\",\n        \"name\": \"X Y\",\n        \"imageurl\": \"http:\\/\\/www.page.com\\/mobileapp\\/uploads\\/profilepics\\/fdsfdsfdsfdsfds.jpg\"\n      },\n      \"bride\": {\n        \"id\": \"12\",\n        \"fbid\": \"455445454\",\n        \"name\": \"dada ssd\",\n        \"imageurl\": \"https:\\/\\/graph.facebook.com\\/2343444344343432323\\/picture?type=large\"\n      }\n    }\n  ]\n}";

public static void main(String[] args) throws JSONException {

    JSONObject jArray= new JSONObject(test);
    JSONArray marrArray = jArray.getJSONArray("marriages");

    for (int i = 0 ; i < marrArray.length(); i++) {
        JSONObject object = marrArray.getJSONObject(i);
        JSONObject planner_object = object.getJSONObject("planner");
        JSONObject groom_object = object.getJSONObject("groom");
        JSONObject bride_object = object.getJSONObject("bride");
        System.out.println(planner_object.optString("imageurl"));
        System.out.println(groom_object.optString("imageurl"));
        System.out.println(bride_object.optString("imageurl"));
   }
}