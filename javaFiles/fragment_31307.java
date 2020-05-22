@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    MenuItem item=menu.getItem(itemIndex); // here itemIndex is int
    item.setTitle("YourTitle");
    return true;
}