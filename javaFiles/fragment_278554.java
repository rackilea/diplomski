else if (requestCode == 10 && resultCode == Activity.RESULT_OK) {
    if (photoFile != null&&LoginController.getInstance().xmppConnection.isConnected()) {
        byte[] photo = AndroidUtilities
                .createProfileImage(photoFile.getAbsolutePath());
        ProfileManager.getInstance().publishPhoto( photo);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(photo, 0, photo.length);
 ->     decodedByte = rotate(decodedByte, orientation);
        avatar.setImageBitmap(decodedByte);
    }else{
        Toast.makeText(this,R.string.LabelProfilePhotoFailed, Toast.LENGTH_SHORT).show();
    }
}