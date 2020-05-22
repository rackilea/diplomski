public class MainMenu extends JFrame implements ActionListener {
    private JButton start, highscore, help, stoppen;
    private int yearNumber, monthNumber, dayNumber, daysInMonth;
    private String yearString, dayString;

    private String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());


public void go(){
    String monthString = getMonthString();
    getDayString();
    getYearString();
    getDayNumber(dayString);
    getYearNumber(yearString);
    getMonthNumber(monthString);
    getDaysInMonth(monthString);
    makeThisMonthFolders();
    maakComponenten();
    maakLayout();
    toonFrame();
}

private void makeComponent() {
    String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());

    String dayString = timeStamp.substring(0,2);

    System.out.println("Today is day " + dayNumber + " of the month");

    String monthString = timeStamp.substring(3, 5);

    System.out.println("Month string: " + monthString);


    start = new JButton("Move Folders"){
        {
            setSize(150, 75);
            setMaximumSize(getSize());
        }
    };
    start.addActionListener(this);
}

private String getMonthString(){
    String monthString = timeStamp.substring(3, 5);

    if(monthString.substring(0,1) == "0"){
        System.out.println(monthString.substring(0,1));
    }
    /*if(monthString.substring(0, 1) == "0"){
        monthString = monthString.substring(1);
    }*/
    return monthString;
}


public int getMonthNumber(String monthString){
    System.out.println(monthString);
    monthNumber = parseInt(monthString);
    return monthNumber;
}