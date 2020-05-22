// Find the PDF in the Webstart App download
  InputStream in = getClass().getResourceAsStream("/where/is/my.pdf");

  // create a temp file to copy the pdf to
  File tmpFile = File.createTempFile("my", "pdf");
  OutputStream out = new FileOutputStream(tmpFile);

  // stream the file from in to out ... heaps of examples on the net for doing this ("copy files")

  // display the file
  Desktop.getDesktop().open(tmpFile);

  // ideally clean the tmp file up at some point.