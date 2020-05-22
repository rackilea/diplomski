/* (non-Javadoc)
 * @see be.intoit.pos.epsonagent.commands.Command#execute()
 */
public void execute() throws Exception {
    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

    StringBuilder  builder = new StringBuilder();
    builder.append(toPrint);
    builder.append(EscapeCodeUtil.createEscapeCode(10));

    PrintRequestAttributeSet aset= new HashPrintRequestAttributeSet();
    aset.add(new MediaPrintableArea(100,400,210,160,Size2DSyntax.MM));


    InputStream is = new ByteArrayInputStream(builder.toString().getBytes("UTF-8"));

    Doc mydoc = new SimpleDoc(is, flavor, null);


       PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

        //print using default
       DocPrintJob
                 job = defaultService.createPrintJob();
                job.print(mydoc, aset);    

}