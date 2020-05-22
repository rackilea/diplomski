File root = new File(Environment.getExternalStorageDirectory()
                            + File.separator + "temp" + File.separator);
                    root.mkdirs();
                    File file= new File(root, "temp.png");

FileOutputStream fOut = new FileOutputStream(file);
                                                 bmp.compress(Bitmap.CompressFormat.PNG, 100, fOut);//bmp is bitmap of ur image
                         fOut.flush();
                         fOut.close();