BufferedReader reader = null;
  BufferedWriter writer = null;
    try {
        reader = new BufferedReader(new FileReader(file));
        String row = null;
        int i = 0;
        List<String> columns = new ArrayList<>();
        while ((row = reader.readLine()) != null) {
            columns.addAll(getColumns(row));

        }

        reader = new BufferedReader(new FileReader(file));
        writer = new BufferedWriter(new FileWriter(outFile));
        int i = 0;
        while ((row = reader.readLine()) != null) {
            writeRow(row, columns, writer);

        }
    } catch (IOException e) {
        e.printStackTrace();
    }