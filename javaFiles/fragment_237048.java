public String readFile(String filePath) {

        String jString = null;
        StringBuilder builder = new StringBuilder();

        File yourFile = new File("/sdcard/" + filepath);
        if (yourFile.exists()) {
            Log.i("file", "file founded");

            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(yourFile));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String row = "";

            try {
                while ((row = bufferedReader.readLine()) != null) {

                    builder.append(row + "\n");
                }

                bufferedReader.close();


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jString = builder.toString();
        }

        else {

            Log.i("FAIL", "FILE NOT FOUND");
        }

        return jString;
    }