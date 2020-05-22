public class Pair {
    private Date from;
    private Date until;
    public Pair(Date from, Date until){
        this.from = from;
        this.until = until;
    }
    public Date getFrom(){ return from; }
    public Date getUntil(){ return until; }
    public void setFrom(Date from){ this.from = from; }
    public void setUntil(Date until){ this.until = until; }
}


List<Pair> listOfMeetings = getDefaultList();
Pair newPair = new Pair(dateFrom, DateUntil)

boolean hasConficts = false;

Calendar newFromCalendar = Calendar.getInstance();
Calendar loopingFromCalendar = Calendar.getInstance();

Calendar newUntilCalendar = Calendar.getInstance();
Calendar loopingUntilCalendar = Calendar.getInstance();

for(Pair p : listOfMeetings) {

    newFromCalendar.setTime(newPair.getFrom());
    loopingFromCalendar.setTime(p.getFrom());

    newUntilCalendar.setTime(newPair.getUntil());
    loopingUntilCalendar.setTime(p.getUntil());

    if (newFromCalendar.after(loopingFromCalendar) && newFromCalendar.before(loopingUntilCalendar) ) {
        hasConficts = true;
        break;
    }
    if (newUntilCalendar.after(loopingFromCalendar) && newUntilCalendar.before(loopingUntilCalendar) ) {
        hasConficts = true;
        break;
    }
}