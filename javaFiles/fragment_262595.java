public void parseJson() {
    try {
        String filepath = Environment.getExternalStorageDirectory()
                + "/j/test.json";
        String data = readFile(filepath);

        JSONObject filedata = new JSONObject(data);
        JSONArray categories = (JSONArray) filedata.get("categories");
        JSONObject categorie = (JSONObject) categories.get(0);
        JSONObject custom_field = (JSONObject) filedata
                .get("custom_fields");
        JSONArray dp_video_posters = (JSONArray) custom_field
                .get("dp_video_poster");

        JSONArray dp_video_files = (JSONArray) custom_field
                .get("dp_video_file");

        // getting title
        String maintitle = (String) filedata.get("title");
        // getting title from categories
        String title = (String) categorie.get("title");
        // getting date
        String date = (String) filedata.get("date");
        // getting poster
        String dp_video_poster = (String) dp_video_posters.get(0);
        // getting video
        String dp_video_file = (String) dp_video_files.get(0);



    } catch (JSONException e) {
        e.printStackTrace();

    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }

}