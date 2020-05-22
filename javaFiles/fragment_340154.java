containerObject = new JSONObject(container);
//has method
if (containerObject.has("video")) {
    //get Value of video
    String video = containerObject.optString("video");
}