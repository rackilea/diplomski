@Override 
public boolean onCreateOptionsMenu(Menu menu) { 
    // Inflate the menu; this adds items to the action bar if it is present. 
    getMenuInflater().inflate(R.menu.menu_search, menu); 

    final MenuItem searchItem = menu.findItem(R.id.action_search); 

    final MultiAutoCompleteSearchView searchView = (MultiAutoCompleteSearchView) 
        MenuItemCompat.getActionView(searchItem); 

    searchView.setQueryHint("Type any word"); 

    MultiAutoCompleteSearchView.SearchAutoComplete searchAutoComplete = 
        (MultiAutoCompleteSearchView.SearchAutoComplete)searchView 
                .findViewById(R.id.search_src_text); 
    //since words are very short 
    searchAutoComplete.setThreshold(1); 

    searchAutoComplete.setAdapter(new DelimiterAdapter( 
            this, 
            android.R.layout.simple_dropdown_item_1line 
    )); 

    searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
        @Override 
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) { 

            String stringBefore, newString; 
            stringBefore = ((DelimiterAdapter)parent.getAdapter()).getMainString(); 
            newString = parent.getAdapter().getItem(position).toString(); 

            searchView.setQuery(stringBefore+newString, false); 
        } 
    }); 


    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { 
        @Override 
        public boolean onQueryTextSubmit(String s) { 
            if(s.length() > 0) { 
                mFindString = s; 

                // do smth with string
                return true; 
            } 
            return false; 
        } 

        @Override 
        public boolean onQueryTextChange(String s) { 
            return false; 
        } 
    }); 

    return true; 
}