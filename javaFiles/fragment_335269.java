try (BufferedReader br = new BufferedReader(new FileReader("sales.dat"))) {

        String line;
        while ((line = br.readLine()) != null) {
            int i = line.indexOf(':');
            if (i != -1)
                System.out.println (line.substring(0, i));
        }
    }