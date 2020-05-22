Intent intent;
if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
    intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
    intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
}else{
    intent = new Intent(Intent.ACTION_GET_CONTENT);
}
intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
intent.setType("image/*");
startActivityForResult(Intent.createChooser(intent, getResources().getString(R.string.form_pick_photos)), REQUEST_PICK_PHOTO);