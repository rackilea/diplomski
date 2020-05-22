public void writetoFile(String filename,String text) {

        File file = new File("/sdcard/" + filename);
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        FileWriter fileWriter;
        try {
//you can change second parametre true or false this is about append or clean and write
            fileWriter = new FileWriter(file, false);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(jsonText);

            bufferedWriter.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }