private ImageIcon ii;

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    JFileChooser chooser = new JFileChooser();
    chooser.showOpenDialog(null);
    final File f = chooser.getSelectedFile();
    String filename = f.getAbsolutePath();
    if (f == null) {
        return;
    }
    jTextField1.setText(filename);

    SwingWorker sw = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            Thread.sleep(5000);//simulate large image takes long to load
            ii = new ImageIcon(scaleImage(120, 120, ImageIO.read(new File(f.getAbsolutePath()))));
            return null;
        }

        @Override
        protected void done() { 
            super.done();
            jLabel1.setIcon(ii);
        }
    };
    sw.execute();

}