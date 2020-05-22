Gson gson = new Gson();

ArrayList<ListAdapterItemsSelected> mSelectedList = new ArrayList<ListAdapterItemsSelected>();
String jsonString = gson.toJson(mSelectedList);
SharedPreferences sp = context.getSharedPreferences("KEY", Context.MODE_PRIVATE);

//Save to SharedPreferences
sp.edit().putString("KEY", jsonString).commit();

//Get to SharedPreferences

//For default value, just to get no errors while getting no value from the SharedPreferences
String empty_list = gson.toJson(new ArrayList<ListAdapterItemsSelected>()); 

ArrayList<ListAdapterItemsSelected> mSelectedList = gson.fromJson(sp.getString("KEY", empty_list),
        new TypeToken<ArrayList<ListAdapterItemsSelected>>() {
        }.getType());