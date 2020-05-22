JFileChooser elegidor = new JFileChooser();
        File originalFile = new File(System.getProperty("user.dir"), "filePDF.pdf");

        elegidor.setCurrentDirectory(new File(System.getProperty("user.dir")));

        elegidor.setSelectedFile(originalFile);

        elegidor.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnVal = elegidor.showSaveDialog(null);
        File destinationFile = null;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            destinationFile = new File(elegidor.getSelectedFile().getAbsolutePath());

            if (!destinationFile.getAbsolutePath().equals(originalFile.getAbsolutePath())) {
                InputStream in = new FileInputStream(originalFile);

                OutputStream out = new FileOutputStream(destinationFile);

                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        }

        if (!destinationFile.getAbsolutePath().equals(originalFile.getAbsolutePath())) {
            originalFile.delete();
        }