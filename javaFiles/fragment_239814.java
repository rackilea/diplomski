ArrayList<String> data=new ArrayList<String>();
    data.add("Predefined1");
    data.add("Predefined2");
    data.add("Predefined3");

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                     android.R.layout.simple_dropdown_item_1line, data.toArray());
             MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView) findViewById(/*View id*/);

MultiAutoCompleteTextView.CommaTokenizer tokenizer=new MultiAutoCompleteTextView.CommaTokenizer();

             textView.setAdapter(adapter);
             textView.setTokenizer(tokenizer);

    textView.setOnEditorActionListener(new TextView.OnEditorActionListener(){
     @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                data.add(v.getText().toString());
                adapter.notifyDataSetChanged();
                return true;    
            }
            return false;
        }

    });

textView.setText("Predefined1,");
tokenizer.terminateToken("Predefined1");


textView.setText(textView.getText().toString()+"Predefined2,");
tokenizer.terminateToken("Predefined2");

textView.setText(textView.getText().toString()+"Predefined3,");
tokenizer.terminateToken("Predefined3");