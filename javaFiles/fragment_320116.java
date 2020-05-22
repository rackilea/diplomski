File dir = Environment.getExternalStoragePublicDirectory(Environment
        .DIRECTORY_DOWNLOADS);
String dirPath = dir.getAbsolutePath();

String[] files = dir.list();
for (String file : files) Log.e("", "File: " + file);