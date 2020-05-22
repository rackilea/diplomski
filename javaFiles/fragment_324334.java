public class Param implements Comparable<Param> {

    //Public just for demo purposes and brevity
    public int start;
    public int end;

    public Param(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Param o) {
        //Needs to be consistent with equals!!
        int result = this.start - o.start;
        if(result == 0) {
            result = (this.end - this.start) - (o.end - o.start);
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + start;
        result = 31 * result + end;  
        return result;
    }

    @Override
    public boolean equals(Object o) {
        ... // null check, reference check etc.
        Param p = (Param) o;
        return this.start == p.start && this.end == p.end;
    }
}