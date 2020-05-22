private void initSearch() {
    results = new ArrayList<Photo>();
    AlertDialog.Builder searchDialog = new AlertDialog.Builder(this);
    AlertDialog dialog = searchDialog.create();
    LayoutInflater inflater = this.getLayoutInflater();
    View v = inflater.inflate(R.layout.search_dialog, null);
    searchDialog.setView(v);
    final EditText tagField = (EditText) v.findViewById(R.id.tagField);
    final EditText valueField = (EditText) v.findViewById(R.id.valueField);
    searchDialog.setTitle("Search Photos");
    searchDialog.setMessage("Specify tag and value...");
    searchDialog.setPositiveButton("Search", new DialogInterface.OnClickListener() {

    @Override
    public void onClick(DialogInterface dialog, int which) {
        try { // PROBLEM: first two lines
              String tag = tagField.getText().toString(); // TAG WILL BE EMPTY
              String value = valueField.getText().toString(); // VALUE WILL BE EMPTY
              String criteria = tag+":\""+value+"\"";
              ArrayList<String> tags = new ArrayList<String>();
              tags.add(criteria);
              HomeScreen.results = c.getPhotosByTag(tags);

              if(!tag.equalsIgnoreCase("person") || !tag.equalsIgnoreCase("location")){
                  throw new IllegalArgumentException("Tag types can only be location or person");
              }else if(results.size() == 0) {
                  throw new IllegalArgumentException("No results");
              }else {
                  Intent intent = new Intent(HomeScreen.this,SearchResults.class);
                  startActivity(intent);
              }
        } catch(Exception e) {
            dialog.dismiss();
            Utilities.createErrorDialog(HomeScreen.this, e.getMessage());
        }

    }
    });
    searchDialog.show();
}