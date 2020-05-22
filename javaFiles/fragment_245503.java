// Save the position of item clicked here
layoutRoot.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View arg0) {
    //JUST TWO LINES
    TinyDB tinydb = new TinyDB(mContext);
    tinydb.putInt("position", position);
    Intent intent = new Intent(G.currentActivity, CounterActivity.class);
    intent.putExtra("POSITION", position);
    G.selectedItemPositon = position;
    G.currentActivity.startActivity(intent);
    }
    });