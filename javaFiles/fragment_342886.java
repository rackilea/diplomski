// lookup for Views
    final EditText e1 = (EditText) rootView.findViewById(R.id.editText);
    final EditText e2 = (EditText) rootView.findViewById(R.id.editText2);
    final Button btn = (Button) rootView.findViewById(R.id.button);

    // TextWatcher definitions (to react on text changes)
    TextWatcher tw = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (e1.getText().length() > 0 && e2.getText().length() > 0) {
                btn.setBackgroundResources(R.drawable.change_stroke);
            } else {
                btn.setBackgroundResources(R.drawable.change_normal);
            }
        }

        @Override
        public void afterTextChanged(Editable s) { }
    }

    // text watcher registration to the 2 EditText
    e1.addTextChangedListener(tw);
    e2.addTextChangedListener(tw);