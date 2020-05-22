list1 = (ListView) findViewById(R.id.my_list);
adapter = new listAdapter(this);
String[] entries={"Normal Text","Normal Text","Normal Text","Normal text","Normal text"};
ArrayList<String> text=Arrays.asList(entries);
adapter.setText(text);
list1.setAdapter(adapter);

Button button1 = (Button) findViewById(R.id.my_button);
button1.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {
       text.set(3,"Different Text");
        adapter.setText(text);
        list1.setAdapter(adapter);

    }
});