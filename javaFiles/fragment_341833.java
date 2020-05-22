LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parent_layout);

    int childViews = parentLayout.getChildCount();
    List<View> hiddenViews = new ArrayList<View>();

    for (int i = 0; i < childViews; i++) {
        View v = parentLayout.getChildAt(i);
        if (v.getVisibility() == View.GONE) {
            hiddenViews.add(v);
        }
    }