private void saveData(DriveApi.DriveContentsResult driveContentsResult, int i) {
            Log.e("CHECk" , "Calling callback " + driveContentsResult.getDriveContents().getDriveId().encodeToString() );
            DriveContents cont = driveContentsResult.getDriveContents();

            Log.e("File name :" ,  "File : " + driveFileList.get(i).getTitle());

//Put your code here
            InputStream inputStream = cont.getInputStream();
            try {

                saveFiles(inputStream, true);
                cont.discard(getGoogleApiClient());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }