public class FcmNotifier {

public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

public static void sendNotification(final String body, final String title) {
    new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                OkHttpClient client = new OkHttpClient();
                JSONObject json = new JSONObject();
                JSONObject notifJson = new JSONObject();
                JSONObject dataJson = new JSONObject();
                notifJson.put("text", body);
                notifJson.put("title", title);
                notifJson.put("priority", "high");
                dataJson.put("customId", "02");
                dataJson.put("badge", 1);
                dataJson.put("alert", "Alert");
                json.put("notification", notifJson);
                json.put("data", dataJson);
                json.put("to", "/topics/topic");
                RequestBody body = RequestBody.create(JSON, json.toString());
                Request request = new Request.Builder()
                        .header("Authorization", "key=your FCM key")
                        .url("https://fcm.googleapis.com/fcm/send")
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();
                String finalResponse = response.body().string();
                Log.i("kunwar", finalResponse);
            } catch (Exception e) {

                Log.i("kunwar",e.getMessage());
            }
            return null;
        }
    }.execute();

}