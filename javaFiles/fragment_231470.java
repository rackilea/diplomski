private static int getComplexReport(AnalyticsReporting service,int 
reportIndex,java.lang.String startDate,String endDate,ArrayList<String>
metricNames,ArrayList<String> dimensionNames,String pageToken)    
throws IOException

ReportRequest req = createComplexRequest(startDate,endDate,metricNames,dimensionNames,pageToken);

ArrayList<ReportRequest> requests = new ArrayList<>();
requests.add(req);

// Create the GetReportsRequest object.
GetReportsRequest getReport = new GetReportsRequest()
    .setReportRequests(requests);

// Call the batchGet method.
GetReportsResponse response = service.reports().batchGet(getReport).execute();
      //printResponse(response);


saveBatchToCsvFile("dummy_"+startDate+"_"+endDate+"_"+Integer.toString(reportIndex)+".csv",startDate+"_"+endDate,response,metricNames,dimensionNames);
String nextToken = response.getReports().get(0).getNextPageToken();
//System.out.println(nextToken);
if(nextToken!=null)
    return getComplexReport(service,reportIndex+1,"2016-06-21","2016-06-21",metricNames,dimensionNames,nextToken);

return reportIndex; 
}