TextWatcher filterTextWatcher = new TextWatcher() { //TextWatcher to Filter RealTime Input Data
            public void beforeTextChanged(CharSequence s, int start, int count,int after)
            {
            }

            public void onTextChanged(CharSequence s,int start, int before,int count)   //Filter Data When Entering Data On ItemType Dialog TextView
            {
            }

            @Override
            public void afterTextChanged(Editable arg0) 
            {   
            }
        };

        EditText filterText = (EditText)dialog.findViewById(R.id.edtItemFilter);
        filterText.addTextChangedListener(filterTextWatcher);