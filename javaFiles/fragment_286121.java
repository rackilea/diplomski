genrecode=new String[entries];
genrename=new String[entries];
for(int i = 0; i < entries; i++) {
    JSONObject jo_genre = (JSONObject) ja_genres.get(i);
    JSONArray ja_genre=jo_genre.getJSONArray("genre");
    JSONObject genreinfo = (JSONObject) ja_genre.get(0);
    genrecode[i]= genreinfo.getString("code");
    genrename[i] = genreinfo.getString("name");
    System.out.println(genrecode[i]);
    System.out.println(genrename[i]);
}