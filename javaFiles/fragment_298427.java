String[] lines = new String[1];

    try {
        FileReader reader = new FileReader(file);
        @SuppressWarnings("resource")
        BufferedReader buffReader = new BufferedReader(reader);
        int x = 0;
        String s;
        while ((s = buffReader.readLine()) != null) {
            lines[x] = s;
            x++;
        }
        ...