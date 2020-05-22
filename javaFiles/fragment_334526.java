MessageFormat header = new MessageFormat("ΟΜΑΔΕΣ ΚΛΑΣΕΙΣ");
         //String TimeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

           Calendar cal = new GregorianCalendar();
               int month =cal.get(Calendar.MONTH);
               int year =cal.get(Calendar.YEAR);
               int day =cal.get(Calendar.DAY_OF_MONTH);

            MessageFormat footer = new MessageFormat("Date "+year+"/"+(month+1)+"/"+day);
           // MessageFormat footer = new MessageFormat("Page{0,number,integer},"  );
            try {
                jTable_Userss.print(JTable.PrintMode.FIT_WIDTH, header, footer);


            } catch (java.awt.print.PrinterException e){
                System.err.format("Cannot print %$%n",e.getMessage());
            }

        }