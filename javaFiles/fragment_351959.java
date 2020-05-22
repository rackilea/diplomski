if(sqlquery.equals("1"))
{
    String sqlq="select Section.Section_Name , Report.Report_Name , Report.Link,         Contact.Contact_Name, Metrics.Metric_Name "
        + "FROM Section , Report , Contact,Metrics "
        + "WHERE Report.Contact_ID=Contact.Contact_ID and Report.Section_ID=Section.Section_ID  "
        + "and Report.Report_ID IN (SELECT Metrics.Report_ID FROM Metrics  WHERE Metrics.Metric_Name = Report.Report_ID') and Metrics.Metric_Segment = 'M' ";

    // Note the try is now nested under the if
    try
    {
         // code continues here