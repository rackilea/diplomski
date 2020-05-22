import javax.swing.*;
import java.awt.*;

public class Days extends JApplet
{
private int month;
private int  day;
private String  year_string;
private String  month_string;
private String  day_string;
private int total_days;
private int month_days;
public final int minMonth = 1;
public final int maxMonth = 12;
public final int minDay = 1;
public final int maxDay = 31;
public final int minYear = 1000;
public final int maxYear = 2999;

public void init()
  {
    month_string = JOptionPane.showInputDialog("Enter the month (" + minMonth +
                                               "-" + maxMonth + ")");
    day_string   = JOptionPane.showInputDialog("Enter the day (" + minDay +
                                               "-" + maxDay + ")");
    year_string  = JOptionPane.showInputDialog("Enter the year (" + minYear +
                                               "-" + maxYear + ")");
     int month = Integer.parseInt( month_string );
     int day = Integer.parseInt( day_string );
     int year = Integer.parseInt( year_string );



    switch (month){
      case 1:
              month_days = 0;
                 break;
      case 2:
              month_days = 31;
                 break;
      case 3:
              month_days = 59;
                 break;
      case 4: ;
              month_days = 90;
                 break;
      case 5:
              month_days = 120;
                 break;
      case 6:
              month_days = 151;
                 break;
      case 7:
              month_days = 181;
                 break;
      case 8:
              month_days = 212;
                 break;
      case 9:
              month_days = 243;
                 break;
      case 10:
              month_days = 273;
                 break;
      case 11:
               month_days = 304;
                  break;
      case 12:
               month_days = 334;
                  break;

        }
     total_days = month_days + day;
  }

  public void paint(Graphics g)
  {
     g.drawString("The number of days from the beginning of " + year_string + " to " + month + "/" + day + "/" + year_string +
                  "= " + total_days, 10, 30);
    showStatus("Alex Collins");
  }
}