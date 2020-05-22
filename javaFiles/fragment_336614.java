each_pays = (TextView) findViewById(R.id.each_pays);
final Context ctx = this;
each_pays_vert.setOnClickListener(new LinearLayout.OnClickListener() {
    @Override
    public void onClick(View _v) {
        // custom dialog
        final Dialog multiples_dialog = new Dialog(ctx);
        ...