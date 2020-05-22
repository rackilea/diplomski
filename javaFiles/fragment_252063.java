Vehicle v=null;
 if(ve > availableList.size() || ve <= 0){
     while(ve > availableList.size() || (!v.isAvailable()))//check if S/No is valid
     {
        System.out.println("Invalid option! please re-enter S/No of of vehicle");
        ve = input.nextInt();//prompt user to re-enter S/No of vehicle

        if(ve <= availableList.size() && ve > 0) {
          v = (Vehicle) vehicleList.get(ve-1);//creates vehicle object
          break;
         }

     }
 }
 else
 {
       v = (Vehicle) availableList.get(ve-1);//creates vehicle object
 }