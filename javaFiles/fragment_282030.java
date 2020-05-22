int week1 = fromDate.get(DateTimeFieldType.weekOfWeekyear());
int year1 = fromDate.get(DateTimeFieldType.year());

int week2 = toDate.get(DateTimeFieldType.weekOfWeekyear());
int year2 = toDate.get(DateTimeFieldType.year());

if(year1 == year2 && week1 == week2){
      System.out.print("In the range of same week");
}