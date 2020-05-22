editor.getMntmNewMenuItem().addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
            String userDir=System.getProperty("user.dir");
            File pdfFile = new File(userDir+"\\Ressources\\test.pdf");
            if (pdfFile.exists()) {

                if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
                } else {
                throw new Exception("Desktop wird nicht unterstützt!");
                }
            } 
            else {
                throw new Exception("Datei ist nicht vorhanden! ");
            }
            } catch (Exception ex) {
JOptionPane.showMessageDialog(editor.getContentPane(), ex.getMessage(), "Fehler",
                JOptionPane.ERROR_MESSAGE);
            }

        }
        });