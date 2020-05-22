while(fileScan.hasNext())
{
   record = fileScan.nextLine();
   String el[] = record.split (" ");
   partNumber = Integer.parseInt (el[0]);
   description = el[1];
   // etc