public class Change {
    private Date weekOfChange; //shoudln't these two fields be one, a date is a date after all??
    private Date dayOfChange; //shoudln't these two fields be one??
    private String changeReason; 

    public Change(Date weekOfChange Date dayOfChange, String changeReason) {
      this.weekOfChange = weekOfChange;
      ...etc.
    } 
}