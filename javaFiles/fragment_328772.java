@Setter
private Date date;

public void setDateFromString(String date) {
  this.date = Date.valueOf(date);
}