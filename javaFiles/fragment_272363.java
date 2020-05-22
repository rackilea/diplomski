list.setOnItemClickListener(new OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        String text = mStrings[position];
        YourImageClass img = mImages[position];
        Intent i = new Intent(MainActivity.this, ShowFullImageActivity.class);
        i.putExtra("TEXT", text);
        i.putExtra("IMAGE", img); // <-- Assumed you image is Parcelable
        startActivity(i);
    }
}