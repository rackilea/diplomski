try{
 File file = new File(Environment.getExternalStorageDirectory()
            + "/Android/Data/" + getApplicationContext().getPackageName()
            + "/files/test1.pdf");
    Intent testIntent = new Intent(Intent.ACTION_VIEW);
    testIntent.setType("application/pdf");
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_VIEW);
    Uri uri = Uri.fromFile(file);
    intent.setDataAndType(uri, "application/pdf");
    try {
        startActivity(intent);
    } catch (ActivityNotFoundException e) {
        Toast.makeText(myactivity .this,
                "No Application Available to View PDF", Toast.LENGTH_LONG).show();
    }
} catch (FileNotFoundException e) {
        Toast.makeText(myactivity .this,
                "No Application Available to View PDF", Toast.LENGTH_LONG).show();
    }