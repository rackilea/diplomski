Toast.makeText(getApplicationContext(),
                    ((TextView) itemClicked).getText(), Toast.LENGTH_SHORT)
                                                    .show();

TextView textview = (TextView) itemClicked;
String strText = textview.getText().toString();