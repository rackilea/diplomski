private AutoCompleteTextView beverageName;
    ...

    beverageName = findViewById( R.id.beverageName );
    ListAdapter adapter = ...
    adapter.setFilter(filter);
    beverageName.setAdapter(adapter);