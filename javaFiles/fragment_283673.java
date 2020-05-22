@Override
    protected void onResume() {
    super.onResume();
    results = new ArrayList<Recipedetails>(); 
    _itemListAdapter = new ItemListBaseAdapter(this, image_details);
    refreshYourAdapter(GetSearchResults());
    lv1.setAdapter(_itemListAdapter);

    }