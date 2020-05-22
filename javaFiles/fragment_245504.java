int position;
    TinyDB tinydb = new TinyDB(mContext);
    tinydb.getInt("position", position);
    Intent intent = new Intent(G.currentActivity, CounterActivity.class);
    intent.putExtra("POSITION", position);
    startActivity(intent);