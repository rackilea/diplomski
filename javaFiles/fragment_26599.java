public void process(@NonNull Frame frame) {
            byte[] data = frame.getData();
                frameWidth = frame.getSize().getWidth();
                frameHieght = frame.getSize().getHeight();

                YuvImage yuv = new YuvImage(data, frame.getFormat(), frameWidth, frameHieght, null);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                yuv.compressToJpeg(new Rect(0, 0, frameWidth, frameHieght), 25, out);
                final byte[] bytes = out.toByteArray();
                frameByteSize = bytes.length;

                if (StreamHandler != null) {
                    OutputStream outputStream = StreamHandler.getOutputStream();
                    if (out != null) {
                        try {
                            byte firstByte = (byte) ((bytes.length & 0xff00) >> 8);
                            byte secondByte = (byte) (bytes.length & 0xFF);
                            outputStream.write(firstByte);
                            outputStream.write(secondByte);
                            outputStream.write(bytes, 0, frameByteSize);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
        }