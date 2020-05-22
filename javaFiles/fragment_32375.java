public void takePictures(final int numOfPictures, final int delay) {

    if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                super.run();
                while (numOfPicturesAlreadyTaken <= numOfPictures) {
                    try {
                        camera = Camera.open();
                        camera.setPreviewDisplay(surfaceView.getHolder());
                        camera.startPreview();
                        camera.takePicture(null, null, new CustomPictureCallbcak(MainActivity.this, cacheDir, imageView));
                        numOfPicturesAlreadyTaken++;
                        sleep(delay);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                        Log.d("TEST", e.getMessage());
                    }
                }
            }
        };
        thread.start();
    }
    else {
        Toast.makeText(this, "No camera found.", Toast.LENGTH_SHORT).show();
    }
}