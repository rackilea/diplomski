public class A1Q2fixed

{ 
 public static void main(String[] parms) // main method
 {
  processHockeyTeams(); 
 } 
 /*****************************/

 public static void processHockeyTeams()  // processing method
 {

  boolean[] winningRecord;

  HockeyTeam[] hockeyTeams;



  hockeyTeams = createTeams(); 

  printTeams(hockeyTeams);

  System.out.print("*********************\n");

  printWinningTeams();

    winningRecord = HockeyTeam.winningRecord(hockeyTeams);

    for(HockeyTeam h:hockeyTeams)
    {
        System.out.println(h.losses);//To access and print losses

             System.out.println(h.otw);//To access and print otw

             System.out.println(h.otl);//To access and print otl

    }


  // printWinningTeams(hockeyTeams); 
 } 

 /*********************************/

 public static void printTeams(HockeyTeam[] hockeyTeams)

 {

   for (int i = 0; i < hockeyTeams.length; i++)

   {

     System.out.println(hockeyTeams[i]);

   }

 }

 public static void printWinningTeams()

 {

 }

 public static HockeyTeam[] createTeams() 
 { 
  HockeyTeam[] teams; 

  HockeyTeam team; 

  int count; 

  teams = new HockeyTeam[HockeyTeams.getNumberTeams()]; 

  team = HockeyTeams.getTeam(); 

  for (count=0; (count<teams.length) && (team!=null); count++) 
  { 

   teams[count] = team; 

   team = HockeyTeams.getTeam(); 

  } 

  return teams; 

 } 

}