myAutoComplete.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            suggestion = searchDB.getSuggestion(s.toString());

            Collections.sort(suggestion);

            String[] item = new String[suggestion.size()];

            item = suggestion.toArray(item);

            for(String word : item)
                System.out.println(word);

        searchAdapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1, item);

        myAutoComplete.setAdapter(searchAdapter);
        myAutoComplete.setThreshold(1);

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {                

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    });