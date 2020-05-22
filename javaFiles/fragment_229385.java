JSONObject jobj = new JSONObject(response);
JSONArray videosjarray = jobj.getJSONArray("videos");
for(int j=0;j < videosjarray.length();j++){
  JSONObject videosJObject = videosjarray.getJSONObject(j);
  JSONObject video = videosJObject.getJSONObject("video");
  String videoid = video.getString("video_id");
  String thumb = video.getString("thumb");
}