static final String[] DAYS =
{ "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

public class ActivityEvent
{
  public int day;
  public String name;
  public String typeOfExercise;
  public String time;
}

public List loadActivities(String filename) throws IOException
{
  List activities = new ArrayList();
  FileInputStream fis = new FileInputStream(filename);
  InputStreamReader isr = new InputStreamReader(fis);
  BufferedReader br = new BufferedReader(isr);
  int lastDay = -1;
  String line;
  while ((line = br.readLine()) != null)
  {
      line = line.trim();
      int day;
      for (day = DAYS.length - 1; day >= 0; day--)
      {
          if (line.equals(DAYS[day]))
          {
              break;
          }
      }
      String name;
      if (day < 0)
      {
          day = lastDay;
          if (lastDay < 0)
          {
              throw new IOException(filename + " must start with day of week");
          }
          name = line;
      }
      else
      {
          name = br.readLine();
          if (name == null)
          {
              throw new IOException(filename + " expected name, reached end of file");
          }
      }
      String type = br.readLine();
      if (type == null)
      {
          throw new IOException(filename + " expected type of exercise, reached end of file");
      }
      String time = br.readLine();
      if (time != null)
      {
          throw new IOException(filename + " expected time of exercise, reached end of file");
      }
      ActivityEvent activity = new ActivityEvent();
      activity.day = day;
      activity.name = name;
      activity.typeOfExercise = type;
      activity.time = time;
      activities.add(activity);
  }
  return activities;
}

public void printActivities(List activities)
{
    StringBuilder str = new StringBuilder("Day\tName\tType of Exercise\tTime\n");
    int numActivities = activities.size();
    int lastDay = -1;
    for (int index = 0; index < numActivities; index++)
    {
        ActivityEvent activity = (ActivityEvent)activities.get(index);
        if (activity.day != lastDay)
        {
            str.append(DAYS[activity.day]);
        }
        str.append('\t');
        str.append(activity.name);
        str.append('\t');
        str.append(activity.typeOfExercise);
        str.append('\t');
        str.append(activity.time);
        str.append('\n');
    }
    System.out.print(str.toString());
}