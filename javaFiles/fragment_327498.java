public class EventTable {
  public void setEvent(Event e) {
    int x = 0;
    columns = e.getFields();
    Event[] savedEvents = e.getSavedEvents();
    for(Event ev : savedEvents) {
      tempdata[x] = ev.getTempData();
      x++;
    }
  }
}