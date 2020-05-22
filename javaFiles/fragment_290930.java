String[] setMethodNames={"FirstName","LastName","Street"};
Class cls = Class.forName("<qualifiedname>Contestant");
Class parameterTypes = String.class;

for(String s:setMethodNames){
    do{
        try{
            flag=false;
            System.out.println("Please enter your "+s+" :");
            String inp=scanner.nextLine();
            cls.getDeclaredMethod("set"+s, parameterTypes ).invoke(contestant1, inp);

         }catch(InvalidInputException e){
            System.out.println(e.getMessage());
            flag = true;
         }
    }while(flag);
}