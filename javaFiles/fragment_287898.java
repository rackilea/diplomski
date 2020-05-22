public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //String value = (String)parent.getItemAtPosition(position);
    String contact = contactList[position];

    Intent callIntent = new Intent(Intent.ACTION_CALL);
    callIntent.setData(Uri.parse("tel:" + phonesList[position])); //***
    startActivity(callIntent);
}