public HourlyEmployee( String first, String last,double payMe,
      double hourlyWage, double hoursWorked ){
      super( first, last );
      setWage( hourlyWage ); // validate and store hourly wage
      setHours( hoursWorked ); // validate and store hours worked
      payMe = earned();
      earnings= hours *wage; 
}