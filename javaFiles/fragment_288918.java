/// GETTING INTENT DATA
        Intent intent = getIntent();
        if (intent.hasExtra("EXTRA_ID")) {
            String id = getIntent().getStringExtra("EXTRA_ID");
              YOUR_SEARCHVIEW.setActivated(true);

                YOUR_SEARCHVIEW.onActionViewExpanded();
                YOUR_SEARCHVIEW.setIconified(false);
                YOUR_SEARCHVIEW.clearFocus();


 ///AT THE END YOU NEED TO SET THE TEXT
                YOUR_SEARCHVIEW.setQuery(id,false);

        }
        else {
            Log.e("NO DATA","NO DATA FOUND");
        }