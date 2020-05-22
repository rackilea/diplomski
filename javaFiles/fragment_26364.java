public String printPackSummary(String groupID, java.sql.Date startDate, java.sql.Date endDate) {
    HttpServletResponse resp = getThreadLocalResponse();

    List<PackSummary> list = getPackSummary(groupID, startDate, endDate);
    StringBuilder fileContent = new StringBuilder();
    for(PackSummary pack : list){
        fileContent.append(pack.getMetric()+","+pack.getMetricTotal()+"\n");
    }
    return URLEncoder.encode(fileContent.toString());
}