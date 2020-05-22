BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader("path"));
        String line = null;
        int count = 0;
        while ((reader.readLine()) != null && count < 11) {
            count++;
        }
        if (count > 10) {
            reader = new BufferedReader(new FileReader("path"));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } else {
            System.out.println(" the file must have at least 10 lines");
        }
        System.out.println("done");
    } catch (Exception e) {
        e.printStackTrace();
    }