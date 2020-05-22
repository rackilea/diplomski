do{  
  x = Integer.parseInt(input.next());  
  switch(x)
  {
     case 1:
        sortByService(services);

        break;
     case 2:
        sortByPrice(services);
        break;
     case 3:
        sortByTime(services);
        break;
     case 0:
         break;
     default:
        System.out.println("Invalid Entry");
  }
}while(x!=0);