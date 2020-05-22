while(fileSize>0){
            if(fileSize < byteSize)
                byteSize = (int)fileSize;
            int byteRead = din.read(b, 0, byteSize);
            fos.write(b);
            fileSize -= byteRead; // <-- See here
        }