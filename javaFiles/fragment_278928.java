final AlertDialog.Builder alert = new AlertDialog.Builder(this);
  final EditText name = new EditText(this);
  final EditText surname = new EditText(this);
  final EditText email = new EditText(this);
  LinearLayout ll=new LinearLayout(this);
  ll.setOrientation(LinearLayout.VERTICAL);
  ll.addView(image);
  ll.addView(name);
  ll.addView(surname);
  ll.addView(email);
  alert.setView(ll);
  alert.setPositiveButton(R.string.enter, new                 
  DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int whichButton) {
      String name_txt = name.getText().toString();
      String surname_txt = surname.getText().toString();
      String email_txt = email.getText().toString();
   }
      });
  alert.show();