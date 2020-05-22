if (validationReportMatcher.find())
{
   String validationReport  = validationReportMatcher.group(1);
   System.out.println ("Match: " + validationReport);
}
else
{
   System.out.println ("No match");
}