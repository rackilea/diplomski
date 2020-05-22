public void buildTable(JPanel panel) throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\test.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            lineArray = new ArrayList<Person>();
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                Person p = new Person(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);
                lineArray.add(p);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> columns = new ArrayList<String>();


        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Address");
        columns.add("Address 2");
        columns.add("City");
        columns.add("State");
        columns.add("Zip Code");
        columns.add("Phone");
        columns.add("Email");

        TableModel tableModel = new DefaultTableModel(Person.toStringsMatrix(lineArray), columns.toArray());
        final JTable table = new JTable(tableModel);

        JScrollPane tableContainer = new JScrollPane(table);
        tableContainer.setBounds(10, 36, 833, 219);
        panel.add(tableContainer);

    }