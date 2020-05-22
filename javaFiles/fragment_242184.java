private static void cipherShifter(String file, int shift) {
        String newFile=file+"_cipher";
        createFile(newFile);
        int numChar;
        try {
            FileInputStream stream=new FileInputStream(file);
            DataInputStream data=new DataInputStream(stream);

            FileOutputStream streamOut=new FileOutputStream(newFile);
            DataOutputStream dataOut=new DataOutputStream(streamOut);
            numBytes=readAllBytes(data);
            stream.close();
            data.close();
            stream=new FileInputStream(file);
            data=new DataInputStream(stream);
            for (int i=0;i<numBytes;++i) {
                byte currentByte=data.readByte();
                if (((currentByte>=65)&&(currentByte<=90))||((currentByte>=97)&&(currentByte<=122))) {
                    currentByte=currentByte+=shift; //need to ensure no overflow beyond a byte
                    dataOut.writeByte(currentByte);
                }
                else {
                    dataOut.writeByte(currentByte);
                }

            }
            data.close();
            dataOut.flush();
            dataOut.close();
        } catch(IOException error) {
            error.printStackTrace();
        }
    }

    private static void createFile(String fileName) {
        File file=new File(fileName);
        if (file.exists()) {
            //Do nothing
        }

        else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                //Do nothing
            }
        }
    }

    private static int readAllBytes(DataInputStream din) throws IOException {
        int count = 0; 
        while (true) { 
            try { 
                din.readByte(); ++count; 
            } catch (EOFException e) { 
                return count; 
            } 
        }
    }