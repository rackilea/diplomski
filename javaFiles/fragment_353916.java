do {
        System.out.println("Enter wall height (feet): ");
        try{
            wallHeight = scnr.nextDouble();
        }catch(InputMismatchException e){
            scnr.next(); //You need to consume the invalid token to avoid an infinite loop
            System.out.println("Input must be a double!");
        }
    } while (!(wallHeight > 0));