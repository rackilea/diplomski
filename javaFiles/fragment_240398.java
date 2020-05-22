public class ListarPosts extends Activity {

        ArrayList<String> URL = null, Titulo = null;

        ArrayList<Post> posts = new ArrayList<Post>();
        int id;
        int tipo;

        public ArrayList<Post> getPosts(String Json) {

            try {
                posts = new ArrayList<Post>();
                URL = new ArrayList<String>();
                Titulo = new ArrayList<String>();
                JSONObject jObject = new JSONObject(Json);

                JSONArray jArray = jObject.getJSONArray("Posts");

                for (int i = 0; i < jArray.length(); i++) {
                    id = jArray.getJSONObject(i).getInt("ID");
                    tipo = 1;
                    final JSONArray jValues = jArray.getJSONObject(i).getJSONArray(
                            "Valores");

                    for (int a = 0; a < jValues.length(); a++) {
                        final String KEY = jValues.getJSONObject(a)
                                .getString("Key");
                        System.out.println(KEY);
                        final String Value = jValues.getJSONObject(a).getString(
                                "Value");
                        System.out.println(Value);

                        if (KEY.equals("URL"))
                            URL.add(Value);
                        else if (KEY.equals("TITULO"))
                            Titulo.add(Value);
                    }

                }
                for (String value : Titulo) {
                        // If you need to use runOnUiThread, you can implement here
                    posts.add(new Post(id, value, tipo));
                }
                return posts;
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
          }
      }