try {

            final String FILENAME = "c:\\Rest\\Test\\data.txt"; //change to your file location
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(FILENAME), "UTF-8")); //change it to your reader
            String line;
            //read file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                Node root = null;
                if (line == "Folder") {
                    root = new Node(null);
                } else {
                    String indexs = line.substring(9, line.length());
                    if (indexs.length() == 2) {
                        // insert to root
                    } else if (indexs.length() == 4) {
                        // create node and use readLine to all sub nodes
                    }
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }