// These..
String string = response.body().toString();
JSONObject jsonObject = new JSONObject(response.body().toString());

// Should've been these..
String string = response.body().string();
JSONObject jsonObject = new JSONObject(response.body().string());