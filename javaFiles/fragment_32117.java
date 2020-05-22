textView.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
        String president = ((TextView) view).getText().toString();
        Intent intent = null;

        if (president.equals("John F. Kennedy"))
            intent = new Intent (MainActivity.this, KennedyActivity.class);
        if (president.equals("Lyndon B. Johnson"))
            intent = new Intent (MainActivity.this, JohnsonActivity.class);
        if (president.equals("Richard Nixon"))
            intent = new Intent (MainActivity.this, NixonActivity.class);
        if (president.equals("Gerald Ford"))
            intent = new Intent (MainActivity.this, FordActivity.class);
        if (president.equals("Jimmy Carter"))
            intent = new Intent (MainActivity.this, CarterActivity.class);
        if (president.equals("Ronald Reagan"))
            intent = new Intent (MainActivity.this, ReaganActivity.class);
        if (president.equals("George H. W. Bush"))
            intent = new Intent (MainActivity.this, SrBushActivity.class);
        if (president.equals("Bill Clinton"))
            intent = new Intent (MainActivity.this, ClintonActivity.class);
        if (president.equals("George W. Bush"))
            intent = new Intent (MainActivity.this, JrBushActivity.class);
        if (president.equals("Barack Obama"))
            intent = new Intent (MainActivity.this, ObamaActivity.class);

        if (intent != null) {
            intent.putExtra("KEY", president);
            startActivity(intent);
        }
    }
});