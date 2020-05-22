DecimalFormat formatter = new DecimalFormat("#0.00");

// create file object
File salesData = new File("SalesData.txt");

// open file
Scanner file  = new Scanner(salesData);

// declare 2 dimensional array 
double[][] weeklySales = new double[3][7];

// loop to initialize token
int row = 0;
while(file.hasNext()) {
// initialize token
String line = file.nextLine();
StringTokenizer tokens = new StringTokenizer(line, ",");

// fill columns and rows
int col = 0;
while(tokens.hasMoreTokens()) {
        // convert to double and assign to token
    weeklySales[row][col] = Double.parseDouble(tokens.nextToken());
    // move up 1 column
    col++;
    }
// move down 1 row
row++;
}

// calculate weekly sales
double week1Sales = 0, week2Sales = 0, week3Sales = 0;
for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 5; j++) {
        double daily = weeklySales[i][j];
        if(i == 0)
            week1Sales += daily;
        else if(i == 1)
            week2Sales += daily;
        else if(i == 2)
            week3Sales += daily;
    }
}
// week 1 sales
System.out.println("Week 1 total sales: $" +formatter.format(week1Sales));
// week 2 sales
System.out.println("Week 1 total sales: $" +formatter.format(week2Sales));
// week 3 sales
System.out.println("Week 1 total sales: $" +formatter.format(week3Sales));

// average daily for week 1
System.out.println("Daily average for week 1: $" +formatter.format(week1Sales / 7));

// average daily for week 2
System.out.println("Daily average for week 2: $" +formatter.format(week2Sales / 7));

// average daily for week 3
System.out.println("Daily average for week 3: $" +formatter.format(week3Sales / 7));

// total for all weeks
double weeklyTotal = week1Sales + week2Sales + week3Sales;

System.out.println("Total sales of all the weeks: $" +formatter.format(weeklyTotal));

// average weekly sales
System.out.println("Average weekly total: $" + formatter.format(weeklyTotal / 3));

// week number with highest sales
if(week1Sales > week2Sales)
    if(week1Sales > week3Sales)
        System.out.println("The week with the highest sales is week 1.");
    else
        System.out.println("The week with the highest sales is week 3.");
else if(week2Sales > week3Sales)
    if(week2Sales > week1Sales)
        System.out.println("The week with the highest sales is week 2.");
    else
        System.out.println("The week with the highest sales is week 1.");
else
    System.out.println("The week with the highest sales is week 3.");

// week number with the lowest
if(!(week1Sales > week2Sales))
    if(!(week1Sales > week3Sales))
        System.out.println("The week with the lowest sales is week 1.");
    else
        System.out.println("The week with the lowest sales is week 3.");
else if(!(week2Sales > week3Sales))
    if(!(week2Sales > week1Sales))
        System.out.println("The week with the lowest sales is week 2.");
    else
        System.out.println("The week with the lowest sales is week 1.");
else
    System.out.println("The week with the lowest sales is week 3.");