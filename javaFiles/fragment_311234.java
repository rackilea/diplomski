SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
text = (TextView)(findViewById(R.id.feedback));

editor.putInt("size", foodList.size());
for (int y=0; y<foodList.size(); y++){
    editor.putInt(Integer.toString(y), foodList.get(y).getItemIdInt());
    editor.putString(Integer.toString(y)+"a", foodList.get(y).getItemName());
    editor.putInt(Integer.toString(y)+"b", foodList.get(y).getTime());
}

editor.commit(); // Save the changes