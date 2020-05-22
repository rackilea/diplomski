String defaultPrinter = PrintServiceLookup.lookupDefaultPrintService().getName();
com.zebra.sdk.comm.Connection myconnection = new com.zebra.sdk.comm.DriverPrinterConnection(defaultPrinter,1000,1000);
myconnection.open();
com.zebra.sdk.printer.ZebraPrinter myprinter = ZebraPrinterFactory.getInstance(myconnection);
String command = "^XA\n" +
                    "^FO50,50\n" +
                    "^A@N,20,20,E:TT0003M_.FNT\n" +
                    "^FDUplatili ste XXXX na račun XXXXXXXXXX^FS\n" +
                    "^FO50,150\n" +
                    "^A0,32,25\n" +
                    "^FD"+ date.toString()+ "^FS\n" +
                    "^FO50,250\n" +
                    "^A0,32,25^FDSlavnoska Avenija 19, 10000 Zagreb^FS\n" +
                    "^XZ";
myprinter.sendCommand(command);
myconnection.close();