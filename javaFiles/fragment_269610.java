MediaScannerConnection.scanFile(CameraPhotoActivity.this, new String[]{file.toString()}, null,
                        new MediaScannerConnection.OnScanCompletedListener() {
                            public void onScanCompleted(String path, Uri uri) {
                                Log.i("External Storage", "Scanned" + path + ":");
                                Log.i("External Storage", "-> uri=" + uri);
                            }
                        });