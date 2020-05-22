Uri selectedImage = imageReturnedIntent.getData();

        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String filePath = cursor.getString(columnIndex);

        String extension =  filePath.substring(filePath.lastIndexOf(".")+1);
        isBusy = true;

        File file = new File(filePath);
        FileInputStream mediaStream = new FileInputStream(file);