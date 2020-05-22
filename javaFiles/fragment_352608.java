camera.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    String storageState = Environment.getExternalStorageState();
                    if (storageState.equals(Environment.MEDIA_MOUNTED)) {
                        long time = System.currentTimeMillis();

                        File root = Environment
                                .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

                        File dir = new File(root.getAbsolutePath() + "/Camera");
                        if (dir.exists() == false) {
                            dir.mkdirs();
                        }

                        String path = dir.getAbsolutePath() + File.separatorChar
                                + time + ".jpg";
                        filesaved = new File(path);
                        try {
                            if (filesaved.exists() == false) {
                                filesaved.getParentFile().mkdirs();
                                filesaved.createNewFile();
                            }

                        } catch (IOException e) {
                            Toast.makeText(
                                    context,
                                    "Unable to create external file"
                                            + storageState, Toast.LENGTH_LONG).show();
                            return;
                        }


                        uritopass = Uri.fromFile(filesaved);
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, uritopass);
                        startActivityForResult(intent, TAKE_PICTURE);
                    } else {
                        Toast.makeText(
                                context,
                                "External Storeage (SD Card) is required.\n\nCurrent state: "
                                        + storageState, Toast.LENGTH_LONG).show();

                    }
                }

            });

    ...
@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == TAKE_PICTURE) {
                //user took a photo
                File imageFile = new File(filesaved.toString());
                Bitmap bm = decodeFile(imageFile);
                if (bm != null) {
                    bm = combineImages(bm);
                    img.setImageBitmap(bm);
                }
            }
        }
}

...