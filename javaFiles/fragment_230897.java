import net.fortuna.ical4j.model.Calendar;

// add this :
// create a new calendar
Calendar cal = new Calendar();
cal.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
cal.getProperties().add(Version.VERSION_2_0);
// set other properties by looking at the documentation..

// your code 
FileOutputStream icsOutputStream = new FileOutputStream(new File("").getAbsoluteFile()+ "classInfo.ics");
CalendarOutputter icsOutputter = new CalendarOutputter();
// send the cal reference directly.
icsOutputter.output(cal,icsOutputStream);