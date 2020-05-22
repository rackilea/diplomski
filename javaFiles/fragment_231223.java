final MyAdapterInterface ad = new MyAdapterInterface() {
            @Override
            public void updateEditText(int value) {
                EditText myEditText = (EditText)findViewById(R.id.edit1);
                myEditText.setText(value);
            }
        };