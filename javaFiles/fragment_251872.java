protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


if (resultCode == RESULT_OK){

            Uri imageUri = data.getData( );
            picturePath = getPath( Add_Picture_Activity.this, imageUri );
            Log.d("Picture Path", picturePath);
}else{
    Toast.makeText(this, "You have not select image", Toast.LENGTH_SHORT).show();
}
    }

 public static String getPath(Context context, Uri uri ) {
        String result = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver( ).query( uri, proj, null, null, null );
        if(cursor != null){
            if ( cursor.moveToFirst( ) ) {
                int column_index = cursor.getColumnIndexOrThrow( proj[0] );
                result = cursor.getString( column_index );
            }
            cursor.close( );
        }
        if(result == null) {
            result = "Not found";
        }
        return result;
    }
    private void getting_data_from_fields_and_sending_on_click_listner() {

        Intent sendingPicPath = new Intent (Add_Picture_Activity.this , Selecting_Activity.class);
       editor = pref.edit() ;
        editor.putString("IMAGEPATH" , picturePath);
        editor.apply();
        startActivity(sendingPicPath);

    }