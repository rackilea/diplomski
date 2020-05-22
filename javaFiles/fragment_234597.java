File photofile = new File(Environment
                    .getExternalStorageDirectory(),"sample"
                    + System.currentTimeMillis() + ".jpg");
            photFileUri = Uri.fromFile(photofile);
            photoPath = photofile.getAbsolutePath();
            Log.v("camera photo path is    ","          "+photoPath);
            Intent cameraIntent = new Intent(
                    android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photFileUri);
            cameraIntent.putExtra("return-data", true);
            startActivityForResult(cameraIntent,1);