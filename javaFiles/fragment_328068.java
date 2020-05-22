File folderName = new File(processingFolder+"/"+f1[i].getName());
            File[] folderFiles= folderName.listFiles();

            for(int m=0;m<folderFiles.length;m++)
            {
                System.out.println("folderFiles are:"+folderFiles[m]);
                //String s1 = new String();
             File readfile = new File(folderFiles[m].toString());
             System.out.println(readfile.exists() + "!!");

             FileInputStream fis = new FileInputStream(readfile);
             ByteArrayOutputStream bos = new ByteArrayOutputStream();

             byte[] buf = new byte[1024];
             try {
                 for (int readNum; (readNum = fis.read(buf)) != -1;) {
                     bos.write(buf, 0, readNum); 
                     //no doubt here is 0
                     /*Writes len bytes from the specified byte array starting at offset 
                     off to this byte array output stream.*/
                 }
             }


             catch (IOException ex) {
             }
             byte[] bytes = bos.toByteArray();

              result2 = Base64.encode( bytes );