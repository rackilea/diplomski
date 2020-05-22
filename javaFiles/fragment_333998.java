Categories item = cateAdapter.getItem(position);
Intent itent = new Intent(getApplicationContext(), ListFood.class);
itent.putExtra("item", item);
int id_categories = item.getId(); //i want to get this variable
String log = "ID: " + id_categories;
itent.putExtra("id_categories", id_categories) //you can call your variable whatever you want, I have called it "id_categories" for convenience.
startActivity(itent);
Log.d("ID: ", log);