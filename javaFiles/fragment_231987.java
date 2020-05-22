package opg3_tour;

/**
 *
 * @author erso
 */
public class RacingCyclist implements Comparable<RacingCyclist> {

    private String name;
    private String team;
    private String country;

    private String time;
    private int mountains;
    private int points;

    public RacingCyclist(String name, String team, String country, String time, int mountains, int points) {
        this.name = name;
        this.team = team;
        this.country = country;
        this.time = time;
        this.mountains = mountains;
        this.points = points;
    }

    // Empty constructor.
    public RacingCyclist() { }

    // Getters

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public int getMountains() {
        return mountains;
    }

    public int getPoints() {
        return points;
    }

    // Setters - They update the data on your Object.

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMountains(int mountains) {
        this.mountains = mountains;
    }

    public void setPoints(int points) {
        this.points = points;
    }

// This method parses lines on the following format: [A.CONTADOR TCS ESP 00:09:48    2   45]
    public void parseLine(String str) {
        str = str.replaceAll("^ +| +$| (?= )", ""); // Removing extra spaces between words.
        str = str.replace("[","");
        str = str.replace("]","");
        String[] lines = str.split(" "); // Breaking the String into lines.

        setName(lines[0]);
        setTeam(lines[1]);
        setCountry(lines[2]);
        setTime(lines[3]);
        setMountains(Integer.parseInt(lines[4]));
        setPoints(Integer.parseInt(lines[5]));
    }

    @Override
    public String toString() {
        return name + " " + team + " " + country + " " + time + " " + mountains + " " + points + "\n";
    }

    @Override
    public int compareTo(RacingCyclist o) {
        if (Integer.parseInt(getTime()) > Integer.parseInt(o.getTime())){ 
            return 1;
        }
        else if (Integer.parseInt(getTime()) < Integer.parseInt(o.getTime())){
            return -1;
        }
        else  {
            return this.name.compareTo(o.name); 
        }
    }
}