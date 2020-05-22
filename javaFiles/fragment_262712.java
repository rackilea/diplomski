public class BackNextGo {

public interface OnData {
    public void updateData(String data);
}

private BackNextGo() {
}

private static String requestUrl;
private static RequestQueue queue;

private static String s;
private OnData sOnData = null;

public static String getPassage(String data, int chapterSelected, OnData onDataCallback) {
    sOnData = onDataCallback;
    setRequestUrl(data, chapterSelected);
    queue = VolleySingleton.getInstance().getRequestQueue();
    sendJsonRequest();
    return getData();
}

private static void setRequestUrl(String s, int chapterSelected) {
    requestUrl = Constants.DISPLAY_DATA_URL_PART_1
            + s.replaceAll("\\s+", "").replaceAll("(\\d+)(?!.*\\d)",
                    String.valueOf(chapterSelected))
                    + Constants.DISPLAY_DATA_URL_PART_2 + Constants.BIBLE_API_KEY;
}

private static String getRequestUrl() {
    return requestUrl;
}

private static void sendJsonRequest() {
    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
            getRequestUrl(), new Response.Listener<JSONObject>() {

        @Override
        public void onResponse(JSONObject response) {

            if (response == null || response.length() == 0) {

            } else {

                try {
                    setData(response
                            .getString(Constants.Keys.Books.KEY_SELECTED_CHAPTER));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    });
    queue.add(request);
}

public static String getData() {
    counter++;
    L.m("getter method");
    return s;
}

private static void setData(String data) {
    s = data;
    if(sOnData != null) {
        sOnData.updateData(data);
    }
    L.m("setter method");
}
}