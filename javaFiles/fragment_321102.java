Intent intent = new Intent();  
intent.setAction(android.content.Intent.ACTION_VIEW);
Uri uri = Uri.parse("file://" + "YOUR_FILE's PATH");
//Or you can use                 
Uri uri = Uri.fromFile(new File("YOUR_FILE's PATH"));
intent.setDataAndType(uri,"image/*");
startActivity(intent);