public class Printing implements Printable {

    private String stringToPrint;

    public Printing(String stringToPrint) {
        this.stringToPrint = stringToPrint;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        g.setColor(Color.black);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));
        g.translate(0, 0);
        int x = 0;
        int y = 100;
        //
        for (String line : stringToPrint.split("\n")) {
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
        }

        return Printable.PAGE_EXISTS;
    }
    public static void printer(String printerData, String designatedPrinter)
        throws IOException, PrinterException {
        try {

            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            PrintService designatedService = null;
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
            AttributeSet aset = new HashAttributeSet();
            aset = new HashAttributeSet();
            aset.add(ColorSupported.NOT_SUPPORTED);
            String printers = "";
            for (int i = 0; i < printServices.length; i++) {
                printers += " service found " + printServices[i].getName() + "\n";
            }
            for (int i = 0; i < printServices.length; i++) {
                System.out.println(" service found " + printServices[i].getName());
                if (printServices[i].getName().equalsIgnoreCase(designatedPrinter)) {
                    System.out.println("I want this one: " + printServices[i].getName());
                    designatedService = printServices[i];
                    break;
                }
            }
            Writer fw = new OutputStreamWriter(new FileOutputStream("printing.txt"), StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw);
            writer.print(printers);
            writer.close();
            PrinterJob pj = PrinterJob.getPrinterJob();
            pj.setPrintService(designatedService);
            Printable painter;

            // Specify the painter
            painter = new Printing(printerData);
            pj.setPrintable(painter);
            pj.print();

        } catch (PrinterException e) {
            Writer fw = new OutputStreamWriter(new FileOutputStream("log.txt", true), StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw);
            e.printStackTrace(writer);
            writer.close();
        }
    }

   }