try {
                JSONObject object = new JSONObject(response);
                JSONArray categoryJsonArray = object.getJSONArray("category");
                for (int i = 0; i < categoryJsonArray.length(); i++) {
                    CategoryModel model = new CategoryModel();
                    JSONObject cat = categoryJsonArray.getJSONObject(i);
                    model.setCategoryID(cat.getString("category_id"));
                    model.setCategoryName(cat.getString("category_name"));
                    categories.add(model);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }