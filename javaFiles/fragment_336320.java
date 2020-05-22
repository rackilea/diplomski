for (Employee e : employeeArray)
{

    if (e!=null && e.getaBook()!=null &&e.getaBook().getBookName() != null && e.getaBook().getBookName().equals(aName))  //modified code

           startDate = e.getaBook().getStartDate();
            Period period = Period.between ( startDate, datePassed );
            daysElapsed2 = period.getDays();
            e.setRetainingTime(daysElapsed2);
            System.out.println(e.getName() + " has passed on "+ e.getaBook().getBookName()+" changing his/her's retaining time to " + daysElapsed2+ ".");
   }

}