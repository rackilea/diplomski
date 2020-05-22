ScheduleExpression exp;

exp = new ScheduleExpression().minute(0).second(0);
exp.dayOfWeek("mon-sat").hour("9,11,13,15,17");
service.createCalendarTime(exp);

exp = new ScheduleExpression().minute(0).second(0);
exp.dayOfWeek("fri").hour("9-14");
service.createCalendarTime(exp);

exp = new ScheduleExpression().minute(0).second(0);
exp.dayOfWeek("sat").hour("9,11,13");
service.createCalendarTime(exp);