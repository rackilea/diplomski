//assuming that getItems() is a List<String> of your Spinner contents
final List<String> liveList = Arrays.asList((String[]) getItems().toArray()); //create mutable List<String> from getItems() List<String>

final Spinner dropdown = new Spinner(this); //spinner (EG: "dropdown") of all the options
dropdown.setLayoutParams(col);
final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new ArrayList<String>());     //      <---+
dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);                                                         //          |
dropdown.setPadding(45, 15, 45, 15);                //                                                                                                  |
dropdown.setAdapter(dataAdapter);                   //the way you [populate] a `dropdown(spinner)` is no longer via a List<String>                      |       

Iterator<String> iter = liveList.iterator(); 
while (iter.hasNext()) {    
    dataAdapter.add(iter.next());
}   //instead of using the constructor we [populate] them "dynamically" directly into the ArrayAdapter


final EditText partSearcher = new EditText(this);
partSearcher.setLayoutParams(col);
partSearcher.addTextChangedListener(new TextWatcher() {
        public void afterTextChanged(Editable s) {
            Log.w("typing",s.toString());
            List<String> keepList = new ArrayList<String>();
            Iterator<String> iter = liveList.iterator(); 
            while (iter.hasNext()) {
                String menow = iter.next();
                if (menow.toLowerCase().contains(s.toString().toLowerCase())) {
                    keepList.add(menow);
                }
            }
            dataAdapter.clear();
            dataAdapter.addAll(keepList);
            dataAdapter.notifyDataSetChanged();
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
});