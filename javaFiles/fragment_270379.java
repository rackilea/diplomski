AutoCompleteTextView textView5 = (AutoCompleteTextView) findViewById(R.id.userName);

        if (textView5.getText().toString().contains("#")) {
            textView5.setError(getResources().getString(R.string.connect_error));
        }
        else{
            (...)
        }