public class Alarm implements Comparable<Alarm> {
   @Override 
    public int compareTo(Object o) {
        Alarm a = (Alarm) o; 
        return this.wakeTime - a.wakeTime ;
    }
}