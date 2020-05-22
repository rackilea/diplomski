import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reader {
    public static void main(String[] a) {
        try{
            String absoluteFilePath = "You Input File Absolute Path";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(absoluteFilePath)));
            String singleEntry = null;
            Player player;
            // Iterate through the file content line by line
            while((singleEntry = bufferedReader.readLine())!=null) {

                // process each line and convert it into a object of player
                // that will be easier to handle going forward
                player = getPlayer(singleEntry);

                // Do anything you want to do with Player
                // I have just printed it out
                System.out.println(getPlayer(singleEntry));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Player getPlayer(String input) {
        Player player = new Player();

        // Tokenizer to break the line into tokens i.e information (here name, day etc)
        StringTokenizer stringTokenizer = new StringTokenizer(input);

        player.setName(stringTokenizer.nextToken(",").trim()); // trim() Just to remove spaces 

        player.setDay(Integer.parseInt(stringTokenizer.nextToken(",").trim())); // trim() Just to remove spaces

        player.setMonth(Integer.parseInt(stringTokenizer.nextToken(",").trim())); // trim() Just to remove spaces

        player.setYear(Integer.parseInt(stringTokenizer.nextToken(",").trim())); // trim() Just to remove spaces

        player.setCountry(stringTokenizer.nextToken(",").trim()); // trim() Just to remove spaces

        player.setPreviousTeams(stringTokenizer.nextToken(",").trim().split("[;]")); // trim() Just to remove spaces

        return player;
    }
}



import java.util.Arrays;

public class Player {
    private String name;
    private int day;
    private int month;
    private int year;
    private String country;
    private String[] previousTeams;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String[] getPreviousTeams() {
        return previousTeams;
    }
    public void setPreviousTeams(String[] previousTeams) {
        this.previousTeams = previousTeams;
    }
    @Override
    public String toString() {
        return "Player [name=" + name + ", day=" + day + ", month=" + month + ", year=" + year + ", country=" + country
                + ", previousTeams=" + Arrays.toString(previousTeams) + "]";
    }   
}