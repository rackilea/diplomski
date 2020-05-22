ListIterator atwlist = arraytowrite.listIterator();
        while (atwlist.hasNext()) {
            ArrayList atwlistline = (ArrayList) atwlist.next();

            ListIterator atwlistlineL = atwlistline.listIterator();
            while (atwlistlineL.hasNext()) {

                firstWriter.write((String) atwlistlineL.next());
                firstWriter.write(",");
            }
            //firstWriter.write("\n");
            System.out.println(atwlistline);
        }
        firstWriter.close();

        //Write original file contents to another file i.e. tempFile2 
        try{
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
        String line = "";
        while((line = bufferedReader.readLine()) != null) {
            secondWriter.write(line);
            secondWriter.write("\n");
        }
        secondWriter.close();
        bufferedReader.close();
        }catch(IOException ie){
            ie.printStackTrace();
            System.out.println("Exception occured while reading from main file");
        }
        //check and remove duplicate entries from file
        try{
        FileReader singleDeviceReader = new FileReader(file1Path);
        FileReader duplicateDeviceReader = new FileReader(file2Path);
        finalWriter = new PrintWriter(filename);

        BufferedReader bufferedReader1 = new BufferedReader(singleDeviceReader);
        BufferedReader bufferedReader2 = new BufferedReader(duplicateDeviceReader);
        String line1 = null;
        String line2 = null;
        boolean fileWriteFlag = false;
        String ifNotFind = "";
        while((line1 = bufferedReader1.readLine())!=null){
            String[] line1Split = line1.split(",");
            ifNotFind = line1;
            while((line2 = bufferedReader2.readLine())!=null){
                String[] line2Split = line2.split(","); 
                if (line2Split[1].equals(line1Split[1])){
                    finalWriter.write(line1);
                    finalWriter.write("\n");
                    fileWriteFlag = true;
                }
                else {
                    finalWriter.write(line2);
                    finalWriter.write("\n");

                }
            }
        }
        if(!fileWriteFlag){
            finalWriter.write(ifNotFind);
        }
        finalWriter.close();
        bufferedReader1.close();
        bufferedReader2.close();

        File t1 = new File (file1Path);
        File t2 = new File (file1Path);
        if (t1.exists()){
            t1.delete();
        }
        if (t2.exists()){
            t2.delete();
        }
        }catch (IOException ioe ){
            ioe.printStackTrace();
            System.out.println("Exception occured while reading both temp files");
        }