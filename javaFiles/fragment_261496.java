// I assume your "time" object is called TimeObj, change it to the correct name in your implementation

Calendar now = Calendar.getInstance();

int dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
TimeObj t = biz.getOpeningHours().get(dayOfTheWeek-1);

Calendar from = Calendar.getInstance();
from.set(Calendar.HOUR_OF_DAY, t.getFromHour());
from.set(Calender.MINUTE, t.getFromMinute());
from.set(Calender.SECOND, 0);

Calendar to = Calendar.getInstance();
to.set(Calendar.HOUR_OF_DAY, t.getToHour());
to.set(Calender.MINUTE, t.getToMinute());
to.set(Calender.SECOND, 0);

if (from.after(to)) {
    // this means to "to" is after midnight, add a day to "to"
    to.set(DATE, to.get(DATE) + 1);
}

boolean insideTime = now.after(from) && now.before(to);