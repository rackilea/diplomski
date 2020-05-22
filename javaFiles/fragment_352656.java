pFldr.listChildren
               (getGoogleApiClient())
               .setResultCallback(new ResultCallback<DriveApi.MetadataBufferResult>() {
                 @Override
                 public void onResult(DriveApi.MetadataBufferResult metadataBufferResult) {
                 int count = metadataBufferResult.getMetadataBuffer().getCount();
                 Log.e("COUNT---", count + "");
                 Log.e("CHECk" , "Calling callback read from googledrive");
                 MetadataBuffer buffer = metadataBufferResult.getMetadataBuffer();
                 if (count > 0) {
                     for (int i = 0; i < count; i++) {
                     final int finalI = i;

                     Log.e("CHECk" , "reading file " + buffer.get(i).getTitle());
                     Log.e("Files avaialbe - ", "" + buffer.get(i).getTitle());
                     driveModel=new DriveModel();
                     DriveId id = buffer.get(i).getDriveId();
                     DriveFile files = Drive.DriveApi.getFile(getGoogleApiClient(), id);

                     if (buffer.get(i).getMimeType().equals("image/jpeg") ||
                           buffer.get(i).getMimeType().equals("image/png")) {

                          driveModel.setTitle(buffer.get(i).getTitle());
                          Log.e("Images avaialbe - ", "" + buffer.get(i).getTitle());
                          // driveModel.setTitle(buffer.get(i).getTitle());


                    files.open(getGoogleApiClient(), DriveFile.MODE_READ_ONLY, null)
                      .setResultCallback(new ResultCallback<DriveApi.DriveContentsResult>() {
                              @Override
                               public void onResult(@NonNull DriveApi.DriveContentsResult driveContentsResult) {
                                               saveData(driveContentsResult, finalI);
                                    }
                                });
                                      driveFileList.add(driveModel);

                                      }

                    if (buffer.get(i).getMimeType().equals("application/x-sqlite3")) {

                           files.open(getGoogleApiClient(), DriveFile.MODE_READ_ONLY, null)
                                  .setResultCallback(new ResultCallback<DriveApi.DriveContentsResult>() {
                                      @Override
                                      public void onResult(@NonNull DriveApi.DriveContentsResult driveContentsResult) {
                                      saveData(driveContentsResult, finalI);
                                 }
                             });

                          }

                      }

                              buffer.release();
                              showMessage("Success");
                     } else {
                               showMessage("No Back Up available.");
                            }

                           }
                 }

            );