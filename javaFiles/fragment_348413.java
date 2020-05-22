class Day {

  private String day;
  private String time;
  private String room;
  private String name;
  private String lecturer;
  private Integer eventId;
  private Boolean modified;

  public void setDay(String day) {
    this.day = day;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public void setRoom(String room) {
    this.room = room;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLecturer(String lecturer) {
    this.lecturer = lecturer;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  public void setModified(Boolean modified) {
    this.modified = modified;
  }
}

class Main{
  private List<List<Day>> days;
  public void setDays(List<List<Day>> days) {
    this.days = days;
  }
}