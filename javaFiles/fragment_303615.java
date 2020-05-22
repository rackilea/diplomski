String jsonResult = db.getResult(keyword);
if (jsonResult == null) {
    jsonResult = runSearch(keyword);
}
final String finalJsonResult = jsonResult;

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent newActivity = new Intent(ResultsActivity.this, MoviePage.class);
        newActivity.putExtra("index", position);
        newActivity.putExtra("json result", finalJsonResult); // Note use of "final" copy
        startActivity(newActivity);
    }
});