ArrayList<Item> items = new ArrayList<Item>();
Gson gson = new Gson

for (Item i : items){
    i.setId(something);
}

for (Item i : items){
    //...
    //send query and get response here
    //...

    i = gson.fromJson(in, Item.class);

}