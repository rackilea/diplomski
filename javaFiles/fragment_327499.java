public abstract class Event {
  public Date getDate() { return(_date); }
  public abstract Event[] getSavedEvents();
  public abstract int[] getTempData();
  public int[] getFormattedDate() {
    ...

}