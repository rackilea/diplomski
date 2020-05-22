//content is a String containing the JSON Object you posted here (with an extra ]).    
JSONArray musicVideosArray = new JSONObject(content).getJSONArray("musicVideos"); //We are only interested in the array
for (int i = 0; i < musicVideosArray.length(); i++) { //For each object in the array
    JSONObject musicVideo  = musicVideosArray.getJSONObject(i);
    //You can already retrieve ID's here if that's all you're interested in:
    //int musicVideoID = musicVideo.getInt("id");
    //if (musicVideoID == 303) {//Do whatever}
    JSONArray aboutTheVideoArray = musicVideo.getJSONArray("thingsAboutTheVideo"); //Get the 'things' array containing ID's
    for (int j = 0; j < aboutTheVideoArray.length(); j++) {
        JSONObject aboutTheVideo = aboutTheVideoArray.getJSONObject(j);
        System.out.println("Object " + (j+1) + " of parent object "  + (i+1) + ", ID: " + aboutTheVideo.getInt("id"));
        //Do whatever
    }
}