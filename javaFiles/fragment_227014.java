public class Runs {
    Teams team;
    final int racklength; // initialization postponed
    int xposteam;

     // constructor defaulting racklength to 60
     public Runs (Teams y){
         team=y;
         racklength=60;
    }

     // constructor with variable initialization of final attribute
     public Runs (int l, Teams y){
         team=y;
         racklength=l;
    }

     // error since racklength is not initialized during construction
     public Runs (){
         team=null
    }
}