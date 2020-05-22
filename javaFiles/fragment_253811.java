Gson gson = new Gson();
ArrayList<String> gsonString = new ArrayList<>();
for(int i=0; i<restaurants.size(); i++)
        gsonString.add(gson.toJson(restaurants.get(i)));
// Store it
tinydb.putListString("tinyRestaurant",gsonString);