private class ConvertArchiveButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
            new Thread(new Runnable() {
            public void run() {
               for (int file = 0; file < listOfFiles.length; file++) {
                  final File f = listOfFiles[i];
                  final idx = file;
                  Thread t = new Thread(new Runnable() {
                    converter.convert(f);
                    swingUtilities.invokeLater(new Runnable() {
                      myProgressBar.setValue(idx);
                    });
                   t.start();
                   t.join();
                  });
                 }
             }).start();
    }
}