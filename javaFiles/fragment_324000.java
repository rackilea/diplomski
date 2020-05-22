dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


TextView clicked= (TextView) v.findViewById(R.id.id_of_textview_that_hold_filename);
String current_file=clicked.getText().toString();

}