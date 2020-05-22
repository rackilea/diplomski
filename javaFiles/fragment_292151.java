ly1 = new LinearLayout(getApplicationContext());
    ly1.setOrientation(LinearLayout.HORIZONTAL);


    View hiddenInfo = getLayoutInflater().inflate(R.layout.layout1, ly1, false);
    ly1.addView(hiddenInfo);

    wm.addView(ly1, params1);