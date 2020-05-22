String card1="A";
    int total=0;
    Scanner input_var=new Scanner(System.in);
    if (card1.equals("A")){
        System.out.println("Do you want a 1 or 11 for the Ace?: ");
        int player_ace_selection=input_var.nextInt();

        while(player_ace_selection != 1 && player_ace_selection != 11){
            System.out.println("Do you want a 1 or 11 for the Ace?: ");
            player_ace_selection = input_var.nextInt();                
        }
        total += player_ace_selection;
    }

    System.out.println(total);