inputSearch.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            textLength = inputSearch.getText().length();
            //allProd_sort and allSpec_sort are ArrayList for search
            allProd_sort.clear();
            allSpec_sort.clear();
            String text = inputSearch.getText().toString();

            //allProdString is the String get from ArrayList allProd
            for (int y =0; y<allProdString.length; y++) {

                  //in my case the search works only if there are min 3 characters in search
                 if (textLength <= allProdString[y].length() && textLength >=3) {

                      if (Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE)
                                .matcher(allProdString[y]).find()) {

                          allProd_sort.add(allProdString[y]);
                          allSpec_sort.add(allSpecString[y]);
                      }
                  }
               }

               String[] allProdStringSort = allProd_sort.toArray(new String[allProd_sort.size()]);
               String[] allSpecStringSort = allSpec_sort.toArray(new String[allSpec_sort.size()]);

               listView.setAdapter(new ListViewAdapter(MainActivity.this, allProdStringSort, allSpecStringSort));
            }

        @Override
        public void afterTextChanged(Editable editable) {

      }
  });