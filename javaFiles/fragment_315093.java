@Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
  //doesn't work if list is clicked
            if(s.length() != 0 && !textView.isPerformingCompletion()){
                db.openDataBase();
                 wl = db.getWordList(s.toString());
                ArrayAdapter<String>  adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line, wl.getWordList());
                textView.setAdapter(adapter);
            }
        }