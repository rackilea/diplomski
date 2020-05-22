public static void main(String[] args)
   {
      int employees, daysAbsent, averageDays;
      employees = noOfEmp();
      daysAbsent= daysMissed(employees);
      averageDays = avgDaysAbsent(employees,daysAbsent);
   }