SimpleDateFormat form = new SimpleDateFormat ("dd-MMM-yyyy");//For parsing
    String datefrom = "01-Aug-2014";
    Date date=form.parse(datefrom);
    SimpleDateFormat myForm = new SimpleDateFormat ("yyyy-MM-dd");//for formating
    System.out.println(myForm.format(date));//new formatted String
   //String formatterDate=myForm.format(date);