saveItem.setOnAction((ActionEvent event) -> {
                // the content of scrollPane is saved as a JPEG file.
                WritableImage img = scrollPane.snapshot(new SnapshotParameters(), null);
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
               // File fileToSave = chooser.getSelectedFile();//Remove this line.
                BufferedImage img2 = SwingFXUtils.fromFXImage(img, null);
                int result = chooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File fileToSave = chooser.getSelectedFile();
                        ImageIO.write(img2, "png", fileToSave);
                    } catch (IOException ex) {
                        Logger.getLogger(GuiClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });