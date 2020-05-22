list.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            String selectedFromList =(String) (list.getItemAtPosition(position));


               MyFragment f = (MyFragment) getSupportFragmentManager()
                      .findViewById(R.id.article_fragment);
               f.setMyText(selectedFromList);

        }
    });