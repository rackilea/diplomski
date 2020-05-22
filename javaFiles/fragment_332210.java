public static void main (String[] args) {
    //dont need to declare variables here. they can be declared in loop like below
    for(int x=0; x<5; x++){
        System.out.println(); //this is called before inner loop, printing a blank line
            for (int y=0; y<4; y++){
                System.out.print(y); //print 0-3 
        }
    }
}