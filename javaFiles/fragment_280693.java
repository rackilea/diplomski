final SpannableString s = new SpannableString("Please send any questions to email@fake.com");

//added a TextView       
final TextView tx1=new TextView(this);
tx1.setText(s);
tx1.setAutoLinkMask(RESULT_OK);
tx1.setMovementMethod(LinkMovementMethod.getInstance());

Linkify.addLinks(s, Linkify.EMAIL_ADDRESSES);
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setTitle("Warning!")
  .setCancelable(false)
  .setPositiveButton("Accept", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
       }
      })
  .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int id) {
               finish();
      }
     })
  .setView(tx1)
  .show();