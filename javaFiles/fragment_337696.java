public class Team{
    private String name;
    private int points;
    private int goalsScored;
    private int goalsRecieved;


    public Team(String teamName, int p, int gs, int gr){
        this.name = teamName;
        this.points = p;
        this.goalsScored = gs;
        this.goalsRecieved = gr;
    }


   public int getPoints(){
       return this.points;
   }

   public void setPoints(int points){
       this.points = points;
   }

   public void setName(String name){
       this.name = name;
   }
}