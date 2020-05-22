private MediaScannerConnection conn;
            private String newFilePath = "New File Path";

            conn = new MediaScannerConnection(this,
                    new MediaScannerConnection.MediaScannerConnectionClient() {

                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            if (path.equals(newFilePath)) {
                                Log.i("Scan Status", "Completed");
 conn.disconnect();
                            }
                        }
                        @Override
                        public void onMediaScannerConnected() {
                            // TODO Auto-generated method stub
                                              conn.scanFile("path of the new file", null);

                        }
                    });
            conn.connect();