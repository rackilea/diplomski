public class DateHandler
{
    public DateHandler(int seconds, int minutes, int hours)
    {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    public String toString()
    {
        return "Seconds: "+seconds+" Minutes: "+minutes+" Hours: "+hours;
    }

    public int seconds;
    public int minutes;
    public int hours;
}

public class Main
{
    public static void main(String args[])
    {
        int[] data = {07, 52, 25, 10, 19, 55, 15, 18, 41}
        int numberOfDates = data.length/3//Divide by 3 because there are 3 numbers per date
        ArrayList<DateHandler> dates = new ArrayList<DateHandler>(numberOfDates);
        for(int x=0;x<numberOfDates;x++)
        {
            int index = x*3;
            DateHandler date = new DateHandler(data[index],data[index+1],data[index+2]);
            System.out.println("added date: "+date.toString());
            dates.add(date);
        }

        //here you can do your calculations.
    }
}