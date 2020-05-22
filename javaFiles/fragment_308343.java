MessageFormat header = new MessageFormat(" Whatever");
MessageFormat footer = new MessageFormat(" Page {0,number,integer}            Whatever");
     try {
         PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
         set.add(OrientationRequested.LANDSCAPE);
         myTable.print(JTable.PrintMode.FIT_WIDTH, header, footer, false, set, false);
         JOptionPane.showMessageDialog(null, "\n" + "JTable was Successfully "
                + "\n" + "Printed on your Default Printer");
     } catch (java.awt.print.PrinterException e) {
         JOptionPane.showMessageDialog(null, "\n" + "Error from Printer Job "
                + "\n" + e);   
     }