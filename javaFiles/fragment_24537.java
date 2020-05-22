boolean headerSectionsRendered = false;
...
private void buildAdapter() {
    String gridViewIdString;

    /* fill the adapter */
    for (String category : mApps.keySet()) {
      /* get all of the apps for current category */
      mAppAdapter = new AppsAdapter(getActivity(), mApps.get(category));

      /* begin programmatically creating the view */
      LinearLayout appListLayout = (LinearLayout) getActivity()
          .findViewById(R.id.appListFragment);

      /* create the section header */
      TextView appSectionHeader = new TextView(getActivity());
      appSectionHeader.setLayoutParams(new LinearLayout.LayoutParams(
          LinearLayout.LayoutParams.MATCH_PARENT,
          LinearLayout.LayoutParams.WRAP_CONTENT));
      appSectionHeader.setText(category);
      LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) appSectionHeader
          .getLayoutParams();
      params.setMargins(15, 8, 15, 5); // left, top, right, bottom
      appSectionHeader.setLayoutParams(params);
      appSectionHeader.setTextSize(16);

      /* create GridView for the current section*/
      GridView appSectionGridView = new GridView(getActivity());
      appSectionGridView.setLayoutParams(new LinearLayout.LayoutParams(
          LinearLayout.LayoutParams.MATCH_PARENT,
          LinearLayout.LayoutParams.WRAP_CONTENT));
      appSectionGridView.setVerticalSpacing(10);
      appSectionGridView.setHorizontalSpacing(10);
      appSectionGridView.setNumColumns(3);
      appSectionGridView.setGravity(Gravity.CENTER);
      appSectionGridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
      appSectionGridView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
            long id) {
          /* position of clicked app and adapter it was located in */
          showApp(position, parent.getAdapter());
        }
      });

      if (!headerSectionsRendered) {
        headerCount++;
        appSectionGridView.setAdapter(mAppAdapter);
        appListLayout.addView(appSectionHeader);
        appListLayout.addView(appSectionGridView);
      }
      if (headerCount == mApps.keySet().size()) {
        headerSectionsRendered = true;
      }
    }
  }