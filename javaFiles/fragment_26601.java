byte[] aSnouty = {97, 98, 99, 100, 101, 102, 103, 104, 105, 49, 45, 50, 51, 52, 53};

    File file = new File("C:/users/BXM0121/testTenTwentyNine.txt");
    FileOutputStream fos = new FileOutputStream(file);
    int fileSizeInBytes = (int) file.length();
    final int maxFileSize = 1029;
    try {
        do {

            if ((maxFileSize - fileSizeInBytes) < aSnouty.length)
            {
                fos.write(Arrays.copyOfRange(aSnouty, 0, maxFileSize-fileSizeInBytes));
                break;
            }
            fos.write(aSnouty); 
            fileSizeInBytes += aSnouty.length;
        } while (file.length() != maxFileSize);

    } catch(Exception ex) {
        ex.printStackTrace();
    } finally{
        fos.close();
    }