public void sendDataBack()
{
  String addText = mSearchText.getText().toString();

  Intent intent = new Intent(MapActivity.this, NewContact.class);
  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
  intent.putExtra("textValue", addText);
  startActivity(intent);

 }