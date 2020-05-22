try{

weight = input.nextDouble();
    }catch(InputMismatchException e){
        System.out.println("You have entered a non numeric field value");
    }
    finally {
    System.out.println("Finally!!! ;) ");
}