public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
  String title = episode_titles.get(position);
  String descrip = episode_description.get(position);
  title = removeBr(title);
  descript = removeBr(descript);
  Toast.makeText(this, title + ": " +  descript, Toast.LENGTH_LONG).show();

}


private String removeBr(String str1){
  return str1.replaceAll("<br/>", "");
}