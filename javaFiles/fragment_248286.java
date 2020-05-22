/*******************
     * Menu Items
     ******************/

   /*
    Menu added to perform search on the action bar. Two menu items:
    2. Open the search area on the action bar so that the user can search.
     */
    @Override
    public void onCreateOptionsMenu(final Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        final MenuItem item = menu.findItem(R.id.action_search);

        final SearchView sv = new SearchView(((MainActivity) getActivity()).getSupportActionBar().getThemedContext());
        sv.setIconifiedByDefault(true);
        sv.setFocusable(true);
        sv.setIconified(false);
        sv.clearFocus();
        sv.requestFocusFromTouch();

        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);


        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                sv.setIconifiedByDefault(true);
                sv.setFocusable(true);
                sv.setIconified(false);
                sv.requestFocusFromTouch();
                return false;
            }
        });

        sv.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                item.collapseActionView();
                hideKeyboard();
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(menu.findItem(R.id.action_search), new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                //DO SOMETHING WHEN THE SEARCHVIEW IS CLOSING
                simpleSearch = null;
                sv.setQuery(null, false);
                hideKeyboard();
                return true;
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("search query submit");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchString) {
                System.out.println(searchString);
                classSearchArray.clear();
                if (searchString.length() > 0) {
                    simpleSearch = searchString.toLowerCase();
                    for (ClassModel classObj : classArray) {
                        if (classObj.getName().toLowerCase().contains(simpleSearch) ||
                                classObj.getCity().toLowerCase().contains(simpleSearch) ||
                                classObj.getStaffName().toLowerCase().contains(simpleSearch) ||
                                classObj.getLocationName().toLowerCase().contains(simpleSearch)) {

                            classSearchArray.add(classObj);
                        }
                    }
                    ClassAdapter adapter = new ClassAdapter(classSearchArray, getActivity(), FindAClassFragment.this);
                    listViewSearch.setAdapter(adapter);

                    listView.setVisibility(View.GONE); //original list view
                    listViewSearch.setVisibility(View.VISIBLE); //search list view

                } else {
                    simpleSearch = null;
                    listView.setVisibility(View.VISIBLE);
                    listViewSearch.setVisibility(View.GONE);
                }
                return false;
            }
        });
    }