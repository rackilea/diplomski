// decode the camera data into an immutable bitmap
Bitmap raw = CameraHelper.decodeYUV(frameInfo.frameData, frameInfo.frameSize.x, frameInfo.frameSize.y);
frameInfo.frameData = null; // allow large bytearry to to get gc'd

Bitmap cameraPic = raw.copy(Bitmap.Config.RGB_565, true);   // make a mutable copy
Canvas c2 = (new Canvas(cameraPic));        // create a canvas from the camera pic

raw.recycle(); // we're done with raw bitmap now and can reclaim from native heap.

reticleOverlay.draw(c2); // reticle overlay is a class that implements View

String filename = acquireNextShotFilename()); // get a filename to write to SD
 FileOutputStream fileoutputStream;
try {
    fileoutputStream = new FileOutputStream(filename);
 } catch (FileNotFoundException e) {
    MyLogger.e("Couldnt open fileoutputstream: ", e);
    throw e;
}  

cameraPic.compress(CompressFormat.PNG, 100, fileoutputStream);
cameraPic.recycle();
try {
    fileoutputStream.flush();
    fileoutputStream.close();
} catch (IOException e) {
    MyLogger.e("Error writing to file: ", e);
    fileoutputStream.close();
}