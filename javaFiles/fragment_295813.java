@Override
   public void compute(MeasureComputerContext context) {
        if (context.getComponent().getType() == FILE) {
           List<Issue> fileIssues = context.getIssues();
           // TODO get number of issues of type MyCustomRule
           context.addMeasure(MY_CUSTOM_METRIC.key(), sum);
        return;
    } 
    int totalSum = 0;
    for (Measure measure : context.getChildrenMeasures(MY_CUSTOM_METRIC.key())) {
        totalSum += measure.getIntValue();
    }

    context.addMeasure(MY_CUSTOM_METRIC.key(), totalSum);
}