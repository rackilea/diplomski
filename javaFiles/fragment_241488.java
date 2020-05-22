import java.io.*;

class P4
{
  public static int get_price(String day_of_week, String age_group)
  {
    int price=0;

    if (day_of_week.equals("WD"))
    {
      if (age_group.equals("adult"))
        price = 66;
      else if (age_group.equals("child"))
        price=48;
      else
        price = 32;
    }
    else
    {
      if (age_group.equals("adult"))
        price = 72;
      else if (age_group.equals("child"))
        price=52;
      else
        price = 36;
  }

  return price;
}