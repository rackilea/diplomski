ArrayList<Day> calender;

ArrayList<Period> periods = new ArrayList<Period>();

for(Day d: calender)
{
   for(Period p : d.getPeriods())
   {
       periods.add(p);
   }
}
listDays.setListData(periods.toArray());