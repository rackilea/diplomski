public void onItemClick(AdapterView<?> a, View v, int position, long id) {
    Intent intent = new Intent(this, Item1.class);
    intent.putExtra("com.painLogger.painLevel", painItems.get(position).get("row_1"));
    intent.putExtra("com.painLogger.painTime" , painItems.get(position).get("row_2"));
    intent.putExtra("com.painLogger.treatment", painItems.get(position).get("row_3"));
    intent.putExtra("painLocation", painItems.get(position).get("row_4"));
    startActivity(intent);
}