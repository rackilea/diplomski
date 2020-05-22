public void askPlayer(char player) {
    Scanner sc = new Scanner(System.in);
    bool ok=false,ok2=false;
    int one, two;
    while(!ok2){//run while the input wanted is already taken
        while(!ok){//run while the input for the first coordinate isn't correct
            System.out.print("Enter first coordiante : ");
            try{
                one=sc.nextInt();
                if(one<1 || one>3)//in the array?
                    System.out.println("Wrong input");
                else
                    ok=true;
            }catch(InputMismatchException e){//a number is entered?
                System.out.println("Wrong input");
            }
        }
        ok=false;
        while(!ok){//same for second coordiante
            System.out.print("Enter second coordiante : ");
            try{
                two=sc.nextInt();
                if(two<1 || two>3)
                    System.out.println("Wrong input");
                else
                    ok=true;
            }catch(InputMismatchException e){
                System.out.println("Wrong input");
            }
        }   
        if(ttBoard[one-1][two-1]!=' ')//taken?
            System.out.println("Case already taken");
        else
            ok2=true;
    }
    ttBoard[one-1][two-1]=player;//affect players character
}