AbstractThreshold at = ThresholdFactory.getThreshold(ar[4]);
if(at != null){
  firstTime = unparsedDate.format(at.getStartDate().getTime());
  secondTime = unparsedDate.format(at.getEndDate().getTime());
} else {
   quarterThreshold();
}