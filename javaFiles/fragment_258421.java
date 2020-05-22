holder.b.setOnClickListener(new View.OnClickListen(){@Override public void onClick(View view) {

Item item = (Item)view.getTag();
DatabaseHandler db = new DatabaseHandler(context);
db.deleteContact(item.getId());//item.getId() refers to your row id that you have fetched from Sqlite
data.remove(position);
notifyDataSetChanged();


Toast.makeText(context,"Removed",Toast.LENGTH_LONG).show();});