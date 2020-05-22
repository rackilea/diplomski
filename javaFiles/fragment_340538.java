int opcion = 0;
do{
    System.out.println(mainMenu);
    opcion = input.nextInt();

    switch(opcion){
        case 1:
            break;
        case 2:
            System.out.println("Search");
            break;
        case 3:
            System.out.println("Erase");
            break;
        default:
            System.out.println("Command not recognize");
            break;
        }
} while(opcion!=4);