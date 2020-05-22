int totalUnits = 0;
int totalReturns = 0;
...
for (DynamoSalesAggregateSummaryRecord record : records){

     totalUnits += record.getUnits();
     totalReturns += record.getReturns();
     ...
}