public static void main(String[] args) {
        FileReader file = null;
        try {
            file = new FileReader(new File("dichromatic.dat"));
        } catch (FileNotFoundException e1) {
            System.err.println("File dichromatic.dat not found!");
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);
        String line;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error when reading");
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Unexpected error");
                    e.printStackTrace();
                }
            }
        }
    }