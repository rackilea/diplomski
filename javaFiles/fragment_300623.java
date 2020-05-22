public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Example clickedexample = listExample.get(position);
    Intent intent = new Intent("com.example.app.EXAMPLEACTIVITY");
    intent.putExtra("detail_1", clickedexample.getDetail1());
    intent.putExtra("detail_2", clickedexample.getDetail2());
    intent.putExtra("detail_3", clickedexample.getDetail3());
    intent.putExtra("detail_icon", clickedexample.getIcon());
    startActivity(intent);
}