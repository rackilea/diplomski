int width = img.getWidth();
                    int height = img.getHeight();
                    int pixelStride = planes[0].getPixelStride();
                    int rowStride = planes[0].getRowStride();
                    int rowPadding = rowStride - pixelStride * width;
                    byte[] newData = new byte[width * height * 4];

                    int offset = 0;
                    bitmap = Bitmap.createBitmap(metrics,width, height, Bitmap.Config.ARGB_8888);
                    ByteBuffer buffer = planes[0].getBuffer();
                    for (int i = 0; i < height; ++i) {
                        for (int j = 0; j < width; ++j) {
                            int pixel = 0;
                            pixel |= (buffer.get(offset) & 0xff) << 16;     // R
                            pixel |= (buffer.get(offset + 1) & 0xff) << 8;  // G
                            pixel |= (buffer.get(offset + 2) & 0xff);       // B
                            pixel |= (buffer.get(offset + 3) & 0xff) << 24; // A
                            bitmap.setPixel(j, i, pixel);
                            offset += pixelStride;
                        }
                        offset += rowPadding;
                    }