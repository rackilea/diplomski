Date date = new Date();
long checkBeforeChange = date.getTime();
CalendarUtil.addDaysToDate(date, 1);
long checkAfterChange = date.getTime();
if(checkBeforeChange != checkAfterChange)
    Window.alert("It works ;)");