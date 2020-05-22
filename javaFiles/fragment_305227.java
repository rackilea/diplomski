JsonArrayRequest favouriteRecipesReq = new JsonArrayRequest(prepareGetMethodUrl(),
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("odpowiedz", "Odpowiedź ulubionych: " + response.toString());

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jObj = response.getJSONObject(i);
                                RecipeItem recipeItem = new RecipeItem();
                                recipeItem.setRecipeUniqueID(jObj.getString("unique_id"));
                                recipeItem.setRecipeTitle(jObj.getString("title"));
                                recipeItem.setRecipeImgThumbnailLink(jObj.getString(
                                        "img_tumbnail_link"));
                                recipeItem.setRecipeAddAte(jObj.getString("add_date"));
                                recipeItem.setRecipeKitchenType(jObj.getString("kitchen_type"));
                                recipeItem.setRecipeMealType(jObj.getString("meal_type"));
                                recipeItem.setRecipeName(jObj.getString("name"));
                                recipeItem.setRecipeSurname(jObj.getString("surname"));
                                recipeItem.setRecipeLikeCount(jObj.getString("like_count"));
                                recipeFavouriteItems.add(recipeItem);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        recipeFavouriteItemsAdapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("odpowiedz", "Błąd pobierania ulubionych: " +
                                Integer.toString(error.networkResponse.statusCode));

                        showSnackbarInfo(Integer.toString(error.networkResponse.statusCode),
                                R.color.snackbar_error_msg);
                    }

                });

        // Adding Request to Request Queue
        AppController.getInstance().addToRequestQueue(favouriteRecipesReq);