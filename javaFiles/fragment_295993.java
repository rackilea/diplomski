public Bb() {
        String aLine;
        Vector columnNames = new Vector();
        Vector data = new Vector();
        boolean found = false;
        StringBuilder temp = new StringBuilder();
        /*Using try catch block with resources Java 7 
          Read about it
        */
        try (FileInputStream fin = new FileInputStream("C:\\Users\\8888"
                + "\\Documents\\NetBeansProjects\\Bb\\src\\bb\\Bbb.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fin))) {

            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            //the first line of the txt file fill colum names
            while (st1.hasMoreTokens()) {
                String s = st1.nextToken();
                columnNames.addElement(s);
            }

            while ((aLine = br.readLine()) != null) {
                String[] sp = aLine.split(" ");
                if (sp[0].equals("0") && !found) {
                    found = true;
                } else if (found) {
                    temp.append(aLine).append("\r\n");
                } else if (!sp[0].equals("0") && !found) {
                    StringTokenizer st2 = new StringTokenizer(aLine, " ");
                    Vector row = new Vector();
                    while (st2.hasMoreTokens()) {
                        String s = st2.nextToken();
                        row.addElement(s);
                    }
                    data.addElement(row);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton button2 = new JButton("SAVE TABLE");
        buttonPanel.add(button2);
        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (table.isEditing()) {
                    int row = table.getEditingRow();
                    int col = table.getEditingColumn();

                    table.getCellEditor(row, col).stopCellEditing();
                }

                int rows = table.getRowCount();
                int columns = table.getColumnCount();

                try {
                    StringBuilder con = new StringBuilder();
                    for (int i = 0; i < table.getRowCount(); i++) {
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            Object Value = table.getValueAt(i, j);
                            con.append(" ");
                            con.append(Value);
                        }
                        con.append("\r\n");
                    }

                    try (FileWriter fileWriter = new FileWriter(new File("C:\\Users\\8888"
                            + "\\Documents\\NetBeansProjects\\Bb\\src\\bb\\cc.txt"))) {
                        fileWriter.write(con.append(temp).toString());
                        fileWriter.flush();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }