InputStream in = null;
try {
log.debug("preparing input stream");
in = getFileTobePrinted();
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

// find the printing service
log.debug("fetching print service");
AttributeSet attributeSet = new HashAttributeSet();
attributeSet.add(new PrinterName("lq2170", null));
PrintService[] services = PrintServiceLookup.lookupPrintServices(null,  attributeSet);

// create the print job
log.debug("creating print job");
DocPrintJob job = services[0].createPrintJob();
Doc doc = new SimpleDoc(in, flavor, null);

// monitor print job events
log.debug("preparing print job monitor");
PrintJobWatcher watcher = new PrintJobWatcher(job);

// print it
log.debug("start printing");
job.print(doc, null);

// wait for the print job is done
log.debug("waiting for the printing to finish");
watcher.waitForDone();

log.debug("done !");
  } finally {
if (in != null) try { in.close(); } catch(Exception e) {}
}