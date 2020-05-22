public void run() {
        int read = 0;
        int hold = 0;
        int frameSize = StreamHandler.getFrameByteSize();
        try {
            if (StreamHandler != null) {
                InputStream inputStream = SrtreamHandler.getInputStream();
                if (inputStream != null) {
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    byte[] frameInfo = new byte[2];
                    while (microPhoneActive) {
                        frameInfo[0] = dataInputStream.readByte();
                        frameInfo[1] = dataInputStream.readByte();
                        ByteBuffer byteBuffer = ByteBuffer.wrap(frameInfo, 0, 2);
                        int bytesToRead = byteBuffer.getShort();
                        byte[] frame = new byte[bytesToRead];
                        dataInputStream.readFully(frame, 0, bytesToRead);
                        Bitmap bitmap = BitmapFactory.decodeByteArray(frame, 0, frame.length);
                        if (bitmap != null) {
                            final Bitmap rotatedBitmap = rotateBitmap(bitmap, -90);
                            frameEvent.onNewFrame(rotatedBitmap);
                        }

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }