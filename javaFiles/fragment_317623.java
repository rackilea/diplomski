private Date maxCalendarDate = new Date();
private Date minCalendarDate= new Date();
public Date getMinCalendarDate() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(minCalendarDate);
    cal.add(Calendar.MONTH, -6);
    minCalendarDate = cal.getTime();        
    return minCalendarDate;
}