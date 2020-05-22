AlertDialog.Builder alert = new AlertDialog.Builder(this);
final EditText edittext = new EditText(ChildMainScreen.this);
edittext.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
edittext.setMaxLines(1);
alert.setMessage("Please enter password to continue");
alert.setView(edittext);
alert.show();