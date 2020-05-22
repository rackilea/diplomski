String[] array = new String[200];
    int index = 0;
    try {
        BufferedReader br = new BufferedReader(new FileReader("./src/cenas.txt"));
        String line = null;
        String[] value = null;

        while ((line = br.readLine()) != null) {
            if (line.isEmpty() || line.trim().equals("")
                    || line.trim().equals("\n")) {
                continue;
            }
            value = line.split("\\s+");

            for (int i = 0; i < value.length; i++) {
                array[index++] = value[i];
                System.out.println("value[" + index + "] = " + value[i]);
            }
        }
        br.close();

    } catch (IOException e) {
        System.out.println("Error!");
    }