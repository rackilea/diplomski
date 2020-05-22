public class Standing implements Comparable<Standing> {

    private String team;
    private Integer time;

    public Standing(String team, Integer time) {
        this.team = team;
        this.time = time;
    }

    public String getTeam() {
        return this.team;
    }

    public Integer getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return this.team + "=" + this.time;
    }

    public int compareTo(Standing standing) {
        return (this.time).compareTo(standing.getTime());
    }
}