while( mode == 1 || mode == 2 ) {
    switch(mode){
    case 1:
        do{
            System.out.print("Enter name:");
            name = hold.nextLine();
            namelist.add(name);

            System.out.print("Do you want to add a name again?(y/n):");
            response = hold.nextLine();
            if(response.equalsIgnoreCase("n")){
                mode = getMode(); // <---- set mode
            }

        }while(response.equalsIgnoreCase("y"));
        break;
    case 2:
        for(int x = 0;x < namelist.size();x++){
            System.out.println(namelist.get(x));

        }
        mode=-1; // <--- break out
        break;
    default:
        System.out.print("ERROR!");
        mode = -1; 
        break;
    }
}
}