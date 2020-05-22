public String readFromFile() {
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(sdcard,".YOURAPP/myFile.txt");
            StringBuilder text = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;

                while ((line = br.readLine()) != null) {
                    text.append(line);
                    text.append('\n');
                }
                br.close();
            }
            catch (IOException e) {
                //You'll need to add proper error handling here
            }
            return text.toString();
        }