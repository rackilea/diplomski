ListView.setOnItemClickListener(new OnItemClickListener()
{
    @Override 
    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
    { 
        Intent intent= new Intent(this,ViewPagerActivty.this);
        intent.putExtra("POS",position);
        startActivity(intent);
        Toast.makeText(YourActivity.this, "" + position, Toast.LENGTH_SHORT).show();
    }
});