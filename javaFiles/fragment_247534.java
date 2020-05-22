String pattern = "MM/dd/yyyy"; 
  SimpleDateFormat format = new SimpleDateFormat(pattern); 
  try { 
    Date date = format.parse("12/31/2006"); 
    System.out.println(format.format(date)); 
  } catch (ParseException e) { 
    e.printStackTrace(); 
  }