AmazonCloudWatch cloudWatch = getAmazonCloudwatchClient();
  List<MetricAlarm> alarmsList = new ArrayList<>();
    do {

        DescribeAlarmsResult result = describeAlarms(cloudWatch, nextToken);
        nextToken = result.getNextToken();
        alarmsList.addAll(result.getMetricAlarms());
    }
    while (nextToken != null);

    for(MetricAlarm alarm : alarmsList){
        DeleteAlarmsRequest request = new DeleteAlarmsRequest();
        request.withAlarmNames(alarm.getAlarmName());
        cloudWatch.deleteAlarms(request);
    }

 private static DescribeAlarmsResult describeAlarms(AmazonCloudWatch cloudWatch, String nextToken){
    DescribeAlarmsRequest request = new DescribeAlarmsRequest();
    request.withStateValue("INSUFFICIENT_DATA");
    request.withNextToken(nextToken);
    return cloudWatch.describeAlarms(request);
}