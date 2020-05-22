String s=Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"/Download/AdobeReader/Getting Started with Adobe Reader.pdf";
Uri uri = Uri.parse(s);

Intent intent = new Intent(getBaseContext(), MuPDFActivity.class);

intent.setAction(Intent.ACTION_VIEW);

intent.setData(uri);



//if document protected with password
intent.putExtra("password", "PDF document password");

//if you need highlight link boxes
intent.putExtra("linkhighlight", true);

//if you don't need device sleep on reading document
intent.putExtra("idleenabled", false);

//document name
intent.putExtra("docname", "PDF document file name");




startActivity(intent);