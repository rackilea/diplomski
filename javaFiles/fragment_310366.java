String printerName="";
....
if (svcName.contains(printerName)||svcName.equals(printerName)) {
                    myPrinter = services[i];
                    System.out.println("my printer found: " + svcName);
                    break;
}