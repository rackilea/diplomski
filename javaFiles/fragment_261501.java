public View getView(int position, View convertView, ViewGroup parent) {
    ....
    TextView mytext = findViewById(R.id.myText);
    int yourVar = getItem(position).var;
    if(yourVar > 0)
    {
        mytext.setTextColor(0x0000FF);
    }else{
        mytext.setTextColor(0xFF0000);
    }
}