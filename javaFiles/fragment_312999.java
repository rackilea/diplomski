LocalDate currentStart=LocalDate.from(start);
LocalDate currentEnd=LocalDate.from(end.plusDays(1));//end is inclusive
do{
    // do what you want with currentStart
    //....
    currentStart=currentStart.plusDays(1);
}while (!currentStart.equals(currentEnd));