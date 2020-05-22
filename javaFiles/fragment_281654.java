String pattern = "MM/dd/yyyy HH:mm:ss";

// Create an instance of SimpleDateFormat used for formatting 
// the string representation of date according to the chosen pattern
DateFormat df = new SimpleDateFormat(pattern);

// Get the today date using Calendar object.
Date today = Calendar.getInstance().getTime();        
// Using DateFormat format method we can create a string 
// representation of a date with the defined format.
String todayAsString = df.format(today);

// Print the result!
System.out.println("Today is: " + todayAsString);