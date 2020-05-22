JSONObject jsonObject = new JSONObject(response); // here response is what you get from php script which is shown at top 
JSONArray message = jsonObject.getJSONArray("result");

for (int i = 0; i < message.length(); i++) {
                    Model model = new Model();
                    JSONObject temp = message.getJSONObject(i);
                    String category = temp.getString("category");
                    String category_color = temp.getString("category_color");


// create array or harshmap to store all data

}