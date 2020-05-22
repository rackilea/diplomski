JFileChooser chooser = new JFileChooser();
chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
chooser.setAcceptAllFileFilterUsed(false);
new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(YourApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        chooser.setSelectedFile(new File("/your/file/path")));
        chooser.approveSelection();
    }
}).start();
chooser.showOpenDialog(null);
String path = chooser.getSelectedFile().getPath();