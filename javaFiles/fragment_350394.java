Intent i = new Intent(Intent.ACTION_VIEW);
File file = new File(f.getAbsolutePath()); 
String extension = android.webkit.MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(file).toString());
String mimetype = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);

//you need define this activity to open your html file.
i.setClassName("com.google.android.browser", "com.android.browser.BrowserActivity");
//intent.setComponent(new ComponentName("com.android.browser", "com.android.browser.BrowserActivity"));

i.setDataAndType(Uri.fromFile(file),mimetype);