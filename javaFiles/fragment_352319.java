Gson gson = new Gson();
    Type collectionType = new TypeToken<List<Orders>>(){}.getType();
    List<Orders> details = gson.fromJson(json, collectionType); // json is your json
    for (int i = 0; i <details.size(); i++) {
        Log.i("Order is ",""+details.get(i).order); // Log the order
        Log.i("Order Number is ",""+details.get(i).number); 
    }