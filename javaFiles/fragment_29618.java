PictureCallback mPicture = new PictureCallback() {
    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        pictureFile = getOutputMediaFile();
        camera.startPreview();

        if (pictureFile == null) {
            //no path to picture, return
            safeToTakePicture = true;
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            fos.write(data);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();              //<-------- show exception
        } catch (IOException e) {
            e.printStackTrace();              //<-------- show exception
        }

        //finished saving picture 
        safeToTakePicture = true;
    }
};