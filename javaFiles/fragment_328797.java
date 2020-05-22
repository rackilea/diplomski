public void actionPerformed(ActionEvent e) {
            vieta.removeAllElements();

            String searchText = findText.getText();
            String[] words = searchText.split(" ");

            StringBuilder sb = null;
            if(words.length > 1) {
                sb = new StringBuilder();
                sb.append(words[1]).append(" ").append(words[0]);
            }

            try (BufferedReader reader = new BufferedReader(new     FileReader(new File("sarasas.txt")))) {

                String text = null;
                while ((text = reader.readLine()) != null) {

                    if (text.contains(searchText) || (sb != null && text.contains(sb.toString()))) {

                        vieta.addElement(text);

                    }

                }

            } catch (IOException ee) {

                ee.printStackTrace();
                JOptionPane.showMessageDialog(Layout.this, "No file", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }