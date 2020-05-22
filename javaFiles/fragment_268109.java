lv.setOnItemClickListener(new OnItemClickListener()
{
    @Override 
    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
    { 
        Intent myIntent = new Intent(context, SubActivity.class);
        myIntent.addFlags(position); //Optional parameters
        context.startActivity(myIntent);
    }
});