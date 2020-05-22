lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        String text=arg0.getItemAtPosition(arg2);
        Intent i=new Intent(context, secondActiviy.class);
        i.putExtra("name", text);
        startActivity(i);
    }
});