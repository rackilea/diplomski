@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode != RESULT_OK) return;
    if (requestCode == PICK_FROM_GALLERY) {
        Uri aa = data.getData();
        mVideoURI = Uri.parse(String.valueOf(aa));
    }
}