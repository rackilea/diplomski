import java.util.ArrayList;
import java.util.Collections;

class Team implements Comparable<Team> {

    int totgoal;
    int points;
    String name;

    Team(int points,int totgoal,String name)
    {
        this.points=points;
        this.totgoal=totgoal;
        this.name=name;

    }
    public String toString()
    {
        return "Name:"+this.name+"  Points:"+this.points+" Goal:"+this.totgoal+"\n";
    }
    @Override
    public int compareTo(Team arg0)
    {
        if(this.points<arg0.points)
            return -1;
        else if(this.points>arg0.points)
            return 1;
        return 0;
    }

    public static void main(String args[])
    {
       ArrayList<Team> a=new ArrayList<Team>();
       a.add(new Team(2,4,"Name1"));
       a.add(new Team(1,2,"Name2"));
       a.add(new Team(3,6,"Name3"));
       System.out.println("ArrayList before Sorting \n"+a);
       Collections.sort(a);
       System.out.println("ArrayList after Sorting \n"+a);
    }
}