public void run() {
                try {
                    downloadFile(getDownloadLinkFromHost());
                    unzip();
                    copyFiles(new File(root), new File("").getAbsolutePath());
                    cleanup();
                    launch.setEnabled(true);
                +   System.gc();
                +   File tmpf = new File(zipFile);
                +   tmpf.deleteOnExit();
                    outText.setText(outText.getText() + "\n¡Actualización completada con éxito!");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al descargar y descomprimir la actualización.", "Error 1", JOptionPane.WARNING_MESSAGE);
                }
            }