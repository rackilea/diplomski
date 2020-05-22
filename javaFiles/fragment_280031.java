try {
                    Metadata pathMetadata = client.files().getMetadata("/test.txt");
                    client.files().download(pathMetadata.getPathLower()).download(outputStream);
                    Log.e("METADATA", pathMetadata.toString());

                } catch (DbxException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }