public static void main(String[] args) throws IOException
{

    int m1, d1, y1, m2, d2, y2;
    Scanner scan = new Scanner(new FileReader("dates.txt"));

    for(int i = 0 ; i < 6; ++i)
    {

        m1 = scan.nextInt();
        d1 = scan.nextInt();
        y1 = scan.nextInt();

        m2 = scan.nextInt();
        d2 = scan.nextInt();
        y2 = scan.nextInt();

        System.out.println("The total number of days between the dates you entered are: " + x(m1, d1, y1, m2, d2, y2));
    }
} 
public static int x (int m1, int d1, int y1, int m2, int d2, int y2)  {
    int total = 0;
    total = d2 - d1 + 1;
    if (y1 == y2) {
        for(int i = m1; i < m2 ; ++i) {
            total += daysInMonth(i, y2);
        }
    } else {
        for (int i = m1; i <= 12; i++) {
            total += daysInMonth(i, y1);
        }
        for (int i = y1+1; i < y2; i++) {
            total += daysInYear(i);
        }
        for (int i = 1; i < m2 ; i++) {
            total += daysInMonth(i, y2);
        }
    }
    return total;
}