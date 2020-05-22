private class ImageAvailableListener implements ImageReader.OnImageAvailableListener {
    @Override
    public void onImageAvailable(ImageReader reader) {
        Image image = null;
        FileOutputStream fos = null;
        Bitmap bitmap = null;

        ByteArrayOutputStream stream = null;

        try {
            image = imageReader.acquireLatestImage();
            if (image != null) {
                Image.Plane[] planes = image.getPlanes();
                ByteBuffer buffer = planes[0].getBuffer();
                int pixelStride = planes[0].getPixelStride();
                int rowStride = planes[0].getRowStride();
                int rowPadding = rowStride - pixelStride * projectionDisplayWidth;

                // create bitmap
                bitmap = Bitmap.createBitmap(projectionDisplayWidth + rowPadding / pixelStride,
                        projectionDisplayHeight, Bitmap.Config.ARGB_8888);
                bitmap.copyPixelsFromBuffer(buffer);

                stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 5, stream);

                if(stream.toByteArray().length < 16000){
                    ByteBuffer byteBuffer = ByteBuffer.wrap(stream.toByteArray());
                    DataChannel.Buffer buf = new DataChannel.Buffer(byteBuffer, true);

                    Log.w("CONFERENCE_SCREEN", "Image size less than chunk size condition");

                    client.sendDataChannelMessage(buf);

                    client.sendDataChannelMessage(new DataChannel.Buffer(Utility.toByteBuffer("\n"), false));
                } else {
                    // todo break files in pieces here

                    ByteBuffer byteBuffer = ByteBuffer.wrap(stream.toByteArray());
                    DataChannel.Buffer buf = new DataChannel.Buffer(byteBuffer, true);
                    client.sendDataChannelMessage(buf);
                    client.sendDataChannelMessage(new DataChannel.Buffer(Utility.toByteBuffer("\n"), false));
                    //   skylinkConnection.sendData(currentRemotePeerId, stream.toByteArray());
                    Log.w("CONFERENCE_SCREEN", "sending screen data to peer :");
                }

                imagesProduced++;
                Log.w("CONFERENCE_SCREEN", "captured image: " + imagesProduced);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

            if (bitmap != null) {
                bitmap.recycle();
            }

            if (image != null) {
                image.close();
            }
        }
    }
}