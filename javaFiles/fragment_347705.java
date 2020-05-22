class StationRecord  {
    private int yearMonthDay = 0;
    private int max = 0;
    private int min = 0;
    private int avg = 0;
    private double dif = 0;

    public StationRecord(int yearMonthDay, int max, int min, int avg, double dif) {
        this.yearMonthDay = yearMonthDay;
        this.max = max;
        this.min = min;
        this.avg = avg;
        this.dif = dif;
    }

    // rest of your code
}

public class Main
{
    public static void main(String[] args) {       
        // rest of your codes
        while (tempdata.hasNextTempRecord()) {
            Scanner scan = new Scanner(tempdata.getNextTempRecord());
            scan.next(); // read until a space and I don't save it for throw it away
            new StationRecord(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextDouble()); 
        }  
        // rest of your codes  
    }
}