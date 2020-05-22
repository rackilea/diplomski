JButton viewerButton = new JButton("View Selected PDF");
  viewerButton.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent actionevent) {
        // Retrieve the pdf file name in the UI thread
        final String[] filename = new String[1];
        Display.getCurrent().syncExec(new Runnable() { 
            public void run() {
                filename[0] = getPDFFileName();
            }
        }

        final File viewerFile = new File(filename[0]);
        final AplotPdfViewer pdfv = new AplotPdfViewer(true);
        try {
           pdfv.openFile(viewerFile);
        }
        catch (IOException e) {
           e.printStackTrace();
        }    
     }
  });