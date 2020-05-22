cronTrigger.getExpressionSummary()
Example:

    CronTrigger t = new CronTrigger();
    t.setCronExpression("0 30 10-13 ? * WED,FRI");
    System.out.println(""+t.getExpressionSummary());
Output:

seconds: 0
minutes: 30
hours: 10,11,12,13
daysOfMonth: ?
months: *
daysOfWeek: 4,6
lastdayOfWeek: false
nearestWeekday: false
NthDayOfWeek: 0
lastdayOfMonth: false
years: *