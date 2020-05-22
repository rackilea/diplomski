@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == getActivity().RESULT_OK) {
        switch (requestCode) {
            case Util.REQUEST_CAMERA:
                try {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) && !Environment.getExternalStorageState().equals(
                            Environment.MEDIA_MOUNTED_READ_ONLY)) {
                        File file = new File(Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+ "./myImages"+ File.separator+ "picture").getPath());
                        if (!file.exists()) {
                            file.mkdirs();
                        }

                        selectedPath1 = File.createTempFile("myImages"+ new SimpleDateFormat("ddMMyyHHmmss",Locale.US).format(new Date()),".jpg", file).toString();
                        croppedImageUri = Uri.fromFile(new File(selectedPath1));

                        Intent intent = new Intent("com.android.camera.action.CROP");
                        intent.setDataAndType(capturedImageUri, "image/*");
                        intent.putExtra("outputX", 400);
                        intent.putExtra("outputY", 400);
                        intent.putExtra("aspectX", 1);
                        intent.putExtra("aspectY", 1);
                        intent.putExtra("scale", true);
                        intent.putExtra("noFaceDetection", true);
                        intent.putExtra("output", croppedImageUri);
                        startActivityForResult(intent, Util.REQUEST_CROP_IMAGE);
        } else {
                        Toast.show(getActivity(), "Please insert memory card to take pictures and make sure it is write able");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case Util.REQUEST_CROP_IMAGE:
                Logg.e(getClass().getSimpleName(), "Profile_Pic ===== " + selectedPath1);
                imgProfile.setImageURI(Uri.parse("file://" + croppedImageUri));

                break;

            default:
                break;
        }
    }
}