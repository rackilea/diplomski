try {
        File file = new File("numbers.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine())!= null) {
            String[] tokens = line.split("\\s");
            System.out.println(Arrays.toString(tokens));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }