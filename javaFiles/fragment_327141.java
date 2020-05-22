public static void main(String[] args) {
        FileReader file = null;
        BufferedWriter bw = null;
        File outputFile = new File("output.formatted");
        try {
            file = new FileReader(new File("dichromatic.dat"));
        } catch (FileNotFoundException e1) {
            System.err.println("File dichromatic.dat not found!");
            e1.printStackTrace();
        }
        try {
            bw = new BufferedWriter(new FileWriter(outputFile));
        } catch (IOException e1) {
            System.err.println("File is not writtable or is not a file");
            e1.printStackTrace();
        }
        BufferedReader br = new BufferedReader(file);
        String line;
        String lineformatted;
        try {
            while ((line = br.readLine()) != null) {
                lineformatted = format(line);
                bw.write(lineformatted);
                // if you need it
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error when processing the file!");
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
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Unexpected error");
                    e.printStackTrace();
                }
            }
        }
    }

    public static String format(String line) {
        // replace this with your needs
        return line.toUpperCase();
    }