try {

            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                JSONArray currentArray = currentObject.getJSONArray("book_details");
                for(int x = 0; x < currentArray.length(); x++){
                    JSONObject book = currentArray.getJSONObject(x);
                    String bookTitle = book.getString("title");
                    String bookDescription = book.getString("description");
                    Log.i("Book Title: ", bookTitle);
                    Log.i("Book Description: ", bookDescription);
                }
            }
 }catch(JSONException e){
     e.printStackTrace();
 }