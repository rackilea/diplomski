String suggesteddir = ".";
            String EXTENSION = ".png";
            JFileChooser fileChooser = new JFileChooser(suggesteddir);
            JFrame choose = new JFrame();
            choose.setTitle("Save To ...");
             int status = fileChooser.showSaveDialog(choose);
            if (status == JFileChooser.APPROVE_OPTION) 
            {

                try 
                {
                    File selectedFile = fileChooser.getSelectedFile();
                    String newfile = selectedFile.getCanonicalPath();
                    if (!newfile.endsWith(EXTENSION)) {
                        newfile=newfile + EXTENSION;
                    }

                    ImageIO.write(img, "png", new File(newfile)); //write img to file

                } catch (IOException ex) {
                    ex.printStackTrace();

                }
            }