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
                String st = "";
                FileInputStream fin = new FileInputStream("C:\\Users\\J Urguby"
                        + "\\Documents\\NetBeansProjects\\Bb\\src\\bb\\Bbb.txt");
                Scanner input = new Scanner(fin).useDelimiter("\\A");
                while (input.hasNext()) {
                    st = input.next();
                    System.out.println("st is " + st);
                }

                FileWriter fileWriter = new FileWriter(new File("C:\\Users\\J Urguby"
                        + "\\Documents\\NetBeansProjects\\Bb\\src\\bb\\cc.txt"));
                fileWriter.write(st);
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    });