String Input = null;
while(true){
    try{
         Input = scanner.nextLine();
         switch (Input) {
            case "Eat":
                blue.eat();
                break;
            case "Sleep":
                blue.sleep();
                break;
            case "Sport":
                blue.sport();
                break;
            case "Condition":
                blue.output();
                break;
            default: 
               throw new IllegalArgumentException("Invalid operation");
        }
    }catch(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }     
}