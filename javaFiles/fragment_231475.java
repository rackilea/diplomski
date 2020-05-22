public class DateAndTime extends MIDlet implements CommandListener{
  private Display disp;
  private Date d;
  private DateField currentDate;
  private Form form;
  private int index;

  public DateAndTime(){
    form = new Form("Data and Time");
    d = new Date();
    currentDate = new DateField("", DateField.DATE_TIME);
    currentDate.setDate(d);
  }

  public void startApp(){
    index = form.append(currentDate);
    disp = Display.getDisplay(this);
    disp.setCurrent(form);
  }

}