InputStream ins = context.getResources().openRawResource (R.raw.FILENAME)
byte[] buffer = new byte[ins.available()];
ins.read(buffer);
ins.close();
FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
fos.write(buffer);
fos.close();


File file = context.getFileStreamPath (FILENAME);
file.setExecutable(true);