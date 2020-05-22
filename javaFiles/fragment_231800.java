public static void main(String[] args) {
        FileInputStream fstream;
        DataInputStream in = null;
        try {
            // Open the file that is the first 
            // command line parameter
            fstream = new FileInputStream("textfile.txt");
            // Get the object of DataInputStream
            in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            //Close the input stream

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }