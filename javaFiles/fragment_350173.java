public class Period implements Serializable
{
  private static final long serialVersionUID = 1L;

  private Calendar          start;

  private Calendar          end;

  private Calendar          startClone;

  private Calendar          endClone;

  private long              durationMillis;

  private long              startMillis;

  private long              endMillis;

  private long              MAX              = 604800000; //A week in millis

  private long              DAY              = 86400000;

  private long              SIX              = 518400000;

  private ArrayList<Week>   weeks;

  /**
   * Constructor accepts 2 Calendars
   * 
   * @param start
   * @param end
   */
  public Period(Calendar start, Calendar end)
  {

    this.start = start;
    this.end = end;
    startClone = (Calendar)start.clone();
    endClone = (Calendar)end.clone();
    startMillis = start.getTimeInMillis();
    endMillis = end.getTimeInMillis();
    durationMillis = endMillis - startMillis;
    int startWeek = start.get(Calendar.WEEK_OF_YEAR);
    int endWeek = end.get(Calendar.WEEK_OF_YEAR);
    weeks = new ArrayList<Week>();

  }

  /**
   * Construct the weeks in this period
   * 
   * @return
   */
  public ArrayList<Week> makeWeeks()
  {
    Calendar borderLine;
    //The meaning of this is to report on weeks, so shorter periods wont be taken in consideration
    if ((durationMillis < MAX) || (endMillis < startMillis))
    {
      return null;
    }
    Calendar endHead = Calendar.getInstance();
    //If first week is not Monday then count the days that have been completed
    if (start.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
    {
      int days = 0;
      start = adjustCalendar(start);//Set time to 0:0:0:0
      days = getDaysToMonday(start.get(Calendar.DAY_OF_WEEK));
      endHead = (Calendar)start.clone();
      endHead.add(Calendar.DAY_OF_YEAR, days - 1);
      weeks.add(new Week(start, endHead, days, calcCompletion(days), setWeekNumber(start)));//was endHead
      //borderLine = endHead.getTimeInMillis() + DAY;
      Calendar vector = endHead;
      vector.add(Calendar.DAY_OF_YEAR, 1);
      borderLine = vector;
    }//head week set

    else
    {
      start = adjustCalendar(start);
      endHead = (Calendar)start.clone();//Successful
      borderLine = (Calendar)endHead.clone();
    }

    long endMillis = 0;

    while ((((borderLine.getTimeInMillis() + SIX)) < (end.getTimeInMillis() + 1)))
    {

      Calendar endNext = Calendar.getInstance();
      Calendar begin = Calendar.getInstance();
      begin = (Calendar)borderLine.clone();
      endNext = (Calendar)borderLine.clone();
      endNext.add(Calendar.DAY_OF_YEAR, 6);
      weeks.add(new Week(begin, endNext, 7, true, setWeekNumber(begin)));
      borderLine.add(Calendar.DAY_OF_YEAR, 7);
      endMillis = endNext.getTimeInMillis();
    }
    //adjust Tail

    Calendar tail = Calendar.getInstance();
    tail.setTimeInMillis(endMillis);

    tail.add(Calendar.DAY_OF_YEAR, 1);//the beginning of the tail

    if (!(tail.get(Calendar.DAY_OF_YEAR) >= end.get(Calendar.DAY_OF_YEAR)))
    {
      tail = adjustCalendar(tail);//set to 00:00:00

      int daysTail = getDaysToTail(end.get(Calendar.DAY_OF_WEEK));
      if (daysTail != 0)
      {
        weeks.add(new Week(tail, end, daysTail, calcCompletion(daysTail), setWeekNumber(end)));
      }
    }
    return weeks;
  }//EOF makeweeks

  /**
   * Get the weekNumber
   * 
   * @return
   */
  private double setWeekNumber(Calendar cal)
  {

    Integer week = cal.get(Calendar.WEEK_OF_YEAR);
    Double clone = week.doubleValue();
    return clone;
  }

  /**
   * This method returns the amount of days between the given day and the next coming Monday
   */
  private int getDaysToMonday(int currentDay)
  {

    switch (currentDay)
    {

      case 1://sunday
        return 1;

      case 2://monday
        return 0;

      case 3://tuesday
        return 6;

      case 4://wednesday
        return 5;

      case 5://thursday
        return 4;

      case 6://friday
        return 3;

      case 7://saturday
        return 2;
    }
    return 0;

  }//EOF method

  /**
   * Returns the day to the end of the final week, always start counting from a Monday
   * 
   * @return
   */
  private int getDaysToTail(int tailDay)
  {

    switch (tailDay)
    {

      case 1://sunday
        return 0;

      case 2://monday
        return 1;

      case 3://tuesday
        return 2;

      case 4://wednesday
        return 3;

      case 5://thursday
        return 4;

      case 6://friday
        return 5;

      case 7://saturday
        return 6;
    }

    return 0;

  }

  /**
   * Returns the amount of weeks stored in this period, completed and non
   * 
   * @return
   */
  public int totalWeeks()
  {
    return weeks.size();
  }

  /**
   * Tells us if the selected period is at least one week, since this is a weekly report, selecting less then a week
   * will return no result.
   * 
   * @return
   */
  public boolean isAtleastWeek()
  {
    long diff = endClone.getTimeInMillis() - startClone.getTimeInMillis();
    if (diff < MAX)
    {
      return false;
    }
    return true;
  }

  /**
   * Provide the dates(start and end of a week) in the form of a String
   * 
   * @param weekNumber
   * @return
   */
  public String getDates(Double weekNumber)
  {

    int weekNumberInt = weekNumber.intValue();

    String vector = new String();

    for (Week week : weeks)
    {
      if (week.getWeekNumber() == weekNumberInt)
      {
        vector += week.getStart().get(Calendar.DAY_OF_MONTH) + "/";
        vector += (week.getStart().get(Calendar.MONTH) + 1) + "/";
        vector += week.getStart().get(Calendar.YEAR) + "-";
        vector += (week.getEnd().get(Calendar.DAY_OF_MONTH)) + "/";
        vector += (week.getEnd().get(Calendar.MONTH) + 1) + "/";
        vector += week.getEnd().get(Calendar.YEAR);
      }
    }
    return vector;
  }

  /**
   * Provided a week-number, gives back a Week marked by that week-number, if existing.
   * 
   * @param weekNumber
   * @return
   */
  public Week getWeek(Double weekNumber)
  {

    int weekNumberInt = weekNumber.intValue();
    for (Week week : weeks)
    {
      if (weekNumberInt == week.getWeekNumber())
      {
        return week;
      }
    }
    return null;
  }

  /**
   * This method will set the calendars time (H:M:S:M) to 0:0:0:0 so to be able to calculate a precise start and End,
   * dates will remain unaltered
   * 
   * @param cal
   * @return
   */
  private Calendar adjustCalendar(Calendar nu)
  {

    nu.set(Calendar.HOUR, 0);
    nu.set(Calendar.MINUTE, 0);
    nu.set(Calendar.SECOND, 0);
    nu.set(Calendar.MILLISECOND, 0);

    return nu;
  }

  /**
   * BBC defines a week "complete" only if 4 or more days of that week have passed.
   * 
   * @param days
   * @return
   */
  private boolean calcCompletion(int days)
  {
    if (days < 4)
    {
      return false;
    }
    return true;
  }

  /**
   * @return
   */
  public boolean hasWeekNumber(Double weekNumber)
  {

    for (Week week : weeks)
    {
      if (weekNumber.intValue() == week.getWeekNumber())
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the highest week number
   * 
   * @return
   */
  public double getHighestWeekNumber()
  {
    return weeks.get(weeks.size() - 1).getWeekNumber();
  }

  /**
   * Test method to print fields of a calendar
   */
  private String showCalValues(Calendar cal)
  {

    return "Day of year " + cal.get(Calendar.DAY_OF_YEAR) + " Day of month: " + cal.get(Calendar.DAY_OF_MONTH)
        + " Day of week: " + cal.get(Calendar.DAY_OF_WEEK) + " month " + cal.get(Calendar.MONTH) + " date: "
        + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.MILLISECOND)
        + " week number: " + cal.get(Calendar.WEEK_OF_YEAR) + " millis: " + cal.getTimeInMillis();
  }

  /**
   * Test method that prints the weeks
   */
  private void showWeeks()
  {
    for (Week w : weeks)
    {
      System.out.println(w.getWeekNumber() + " start millis: " + w.getStart().getTimeInMillis());
    }
  }
}