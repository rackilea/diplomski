private ArrayList[] lists;
private ArrayList peg1 = new ArrayList<>();
private ArrayList peg2 = new ArrayList<>();
private ArrayList peg3 = new ArrayList<>();

//Constructor
public TowersOfHanoi() {

   lists = new ArrayList[3];
   lists[0]= this.peg1;
   lists[1]= this.peg2;
   lists[2]= this.peg3;

}