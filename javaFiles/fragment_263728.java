public static void main (String args[]) {

    Scanner sc = new Scanner (System.in);
    boolean game_start=false;
    char c;

while(!game_start){
        System.out.println("press o to play first");
        System.out.println("press x to play second");

         c = sc.next().charAt(0);

        System.out.println("You entered " + c);

        if(c!='o' && c!='x') 
            System.out.println("you can only enter o or x!");  
        else 
            game_start = true;   
        }
}