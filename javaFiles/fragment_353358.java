DriveContents contents = driveContentsResult.getDriveContents();

 try {

      String input = et.getText().toString();

      ParcelFileDescriptor parcelFileDescriptor = contents.getParcelFileDescriptor();
      FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptor
                            .getFileDescriptor());

      // Read to the end of the file.

     fileInputStream.read(new byte[fileInputStream.available()]);


      // Append to the file.
      FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor
                            .getFileDescriptor());
      Writer writer = new OutputStreamWriter(fileOutputStream);
      writer.write("\n"+input);

      writer.close();
      driveContentsResult.getDriveContents().commit(mGoogleApiClient, null);

 } catch (IOException e) {
                    e.printStackTrace();
     }