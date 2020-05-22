Calendar cal = Calendar.getInstance();
cal.setTime(calendar.getDate());
int day = cal.get(Calendar.DAY_OF_MONTH);
int month = cal.get(Calendar.MONTH);
int year = cal.get(Calendar.YEAR);

JPanel jpanel = calendar.getDayChooser().getDayPanel();
Component component[] = jpanel.getComponents();

//arraylist of events
for(int i = 0; i < events.size(); i++)
{
    //selected month and year on JCalendar
    if(month == events.get(i).getMonth() && year == events.get(i).getYear())
    {
         // Calculate the offset of the first day of the month
         cal.set(Calendar.DAY_OF_MONTH,1);
         int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;

        //this value will differ from each month due to first days of each month
         component[ events.get(i).getDay() + offset ].setBackground(Color.blue); 
    }
}