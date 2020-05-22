btnClick = new ButtonClickListener();
for(int id:idList){
    View v;
    v = (View) findViewById(id);
    v.setOnClickListener(btnClick);
}