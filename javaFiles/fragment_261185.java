FileInputStream fileInputStream=openFileInput("file.txt");
        InputStreamReader InputRead= new InputStreamReader(fileInputStream);

        char[] inputBuffer= new char[READ_BLOCK_SIZE];
        String s="";
        int charRead;

        while ((charRead=InputRead.read(inputBuffer))>0) {
            String rs=String.copyValueOf(inputBuffer,0,charRead);
            s +=rs;
        }
        InputRead.close();
        Log.d(TAG,s);