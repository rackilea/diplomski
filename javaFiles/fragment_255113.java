class Player extends AsyncTask<BitmapRenderer, Bitmap, Object> {
    BitmapRenderer glRenderer;
    FFmpegFrameGrabber grabber = null;

    @Override
    protected Bitmap doInBackground(BitmapRenderer... objects) {
        glRenderer = objects[0];

        try {
            grabber = new FFmpegFrameGrabber("/storage/emulated/0/Download/test.mp4");
            grabber.start();
            OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();
            Frame grabbedImage;
            while ((grabbedImage = grabber.grabImage()) != null) {
                Log.e("Android", "Frame Grabbed " + grabbedImage.imageWidth + "x" + grabbedImage.imageHeight);
                AndroidFrameConverter frameConverter = new AndroidFrameConverter();
                Bitmap bitmap = frameConverter.convert(grabbedImage);
                publishProgress(bitmap);

                opencv_core.Mat grabbedMat = converter.convert(grabbedImage);
                if (grabbedMat != null)
                    imwrite("/storage/emulated/0/Download/videoplayback.jpg", grabbedMat);
            }

        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
            Log.e("Android", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Bitmap... values) {
        super.onProgressUpdate(values);
        glRenderer.draw(values[0]);
    }

    @Override
    protected void onPostExecute(Object objects) {
        super.onPostExecute(objects);
        try {
            grabber.stop();
            grabber.release();
        } catch (FrameGrabber.Exception e1) {
        }
    }
}