File myExternalFile = new File(getExternalFilesDir(filepath), "file.txt");


                     try {
        FileOutputStream fos = new FileOutputStream(myExternalFile);
          OutputStreamWriter osw = new OutputStreamWriter(fos);
          osw.append(text.getEditableText().toString());
          osw.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }