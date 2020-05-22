JButton addCD = new JButton("Press to add the CD");
addCD.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            FileWriter fw = null;
            try {
                fw = new FileWriter("cd.dat");
                myTextArea.write(fw);
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    });