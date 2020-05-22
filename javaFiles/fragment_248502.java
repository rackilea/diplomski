public void txt() throws IOException {

        // open the LinkAl txt file
        File file = new File("LinkAl.txt");
        String line="";
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));
        while ((line = reader.readLine()) != null) {

                    // System.out.println(line);
                       link(line);

            }
        }