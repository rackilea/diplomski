public class Pool
{  
    private int teamCounter;
    ...

    public Pool(String aName)
    {
        super();
        this.poolName = aName;
        this.teams = new Team[NOOFTEAMS];
        teamCounter=0;
    }

    ...

    public void loadTeams()
    {
        ...
        //somewhere here I need to add the aTeam object to the array
        this.teams[teamCounter++]=aTeam;

    }
}