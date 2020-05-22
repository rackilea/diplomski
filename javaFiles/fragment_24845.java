public static void main(String[] args) {

    System.out.println("Type 1 to enter a denomination, 2 to enter a last name");
    Scanner in = new Scanner(System.in);
    int x = Integer.parseInt(in.nextLine());

    if(x==1){
        System.out.println("Choose a denomination");
        int y = Integer.parseInt(in.nextLine());
        in.nextLine();
        if(y==1){
            System.out.println("Which person appears on the 1 bill?");
            String answer = in.nextLine();
            if(answer.equals("Washington")){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }


        else if(y==10){
            System.out.println("Which person appears on the 10 bill?");
            String answer = in.nextLine();
            if(answer.equals("Hamilton")){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }
        else if(y==100){
            System.out.println("Which person appears on the 100 bill?");
            String answer = in.nextLine();
            if(answer.equals("Franklin")){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }
        else{
            System.out.println("That is an invalid number.");
        }
    }
    else if(x==2){
       System.out.println("Choose a name");
        String y = in.nextLine();
        //in.nextLine();
        if(y.equals("Washington")){
            System.out.println("Which denomination does this name appear on?");
            int answer = Integer.parseInt(in.nextLine());
            if(answer==1){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }


        else if(y.equals("Hamilton")){
            System.out.println("Which denomination does this name appear on");
            int answer = Integer.parseInt(in.nextLine());
            if(answer==10){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }
        else if(y.equals("Franklin")){
            System.out.println("Which denomination does this name appear on");
            int answer = Integer.parseInt(in.nextLine());
            if(answer==100){
                System.out.println("That is correct");
            }
            else{
                System.out.println("That is incorrect");
            }
        }
        else{
            System.out.println("That is an invalid number.");
        }
    } 
}