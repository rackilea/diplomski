final JSONObject arr = new JSONObject();

for (int i = 0; i < contactStatus.size(); i++) {
    ContactStatus contactObject = contactStatus.get(i);

    try {
        arr.put(String.valueOf(i), toJson(value1, value2,, value3));
    } catch (JSONException e) {

     catch block e.printStackTrace();
    }
}

//Here we serialize the stream to a String.
final String output = arr.toString();
response.setContentLength(output.length());
out.print(output);//out is object of servlet output stream.

public static Object toJsonForContact(String value1, boolean value2, double value3) throws JSONException {

    JSONObject contactObject = new JSONObject();
    contactObject.put("id", id);
    contactObject.put("status", value1);
    contactObject.put("distance", value2);
    contactObject.put("relation", value3);
    return contactObject;
}