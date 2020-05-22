String ext = ".3gp";

File folder = new File(Environment.getExternalStorageDirectory() + "/" + getString(R.string.app_name));
if(!folder.exists()) {
    folder.mkdirs();
}

file_name = folder.getAbsolutePath() + "/";

if(editText.getText().length() > 0) {
    file_name += editText.getText().toString() + ext;
} else {
    file_name += Calendar.getInstance().getTimeInMillis() + ext;
}

File outputFile = new File(file_name);

// ...