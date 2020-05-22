Pattern p = Pattern.compile(".+to\\s+date\\s*?:\\s*?([0-9]{2}[\\./][0-9]{2}[\\./][0-9]{2,4}).+", Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher("... \n From Date :01/11/2011 To Date :30/11/2011;;;;;;;;;;;;; \n ...");

System.out.println(m.matches()); // prints false

if(m.find()) {
  System.out.println(m.group(1)); // prints 30/11/2011
}