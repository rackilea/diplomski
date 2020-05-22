if (main.isValidDate(month, day, year) == true) 
{
    main.newFormat(month, day, year);
    main.isLeapYear(year);
    main.dayNumber(month, day);
}
else if (main.isValidDate(month, day, year) == false)
{
    System.out.println("Invalid Input");
}