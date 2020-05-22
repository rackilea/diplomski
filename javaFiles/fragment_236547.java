public class Bowler {
private String name;
private double over;
private int maiden;
private int runs;
private  int wickets;   

public Bowler(String input){
    String[] str=input.split("-");
    this.name=str[0];
    this.over=Double.parseDouble(str[1]);
    this.maiden=Integer.parseInt(str[2]);
    this.runs=Integer.parseInt(str[3]);
    this.wickets=Integer.parseInt(str[4]);
}

public String getName() {
    return name;
}


public double getOver() {
    return over;
}


public int getMaiden() {
    return maiden;
}


public int getRuns() {
    return runs;
}


public int getWickets() {
    return wickets;
}
}