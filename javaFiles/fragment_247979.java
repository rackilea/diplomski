int i;
    while(scan.hasNextInt()==false){ //keep asking until it gets something it likes
        scan.next(); //<--consume bad input, important!
        System.out.println("Only integers are valid");
    }
    i=scan.nextInt();

    System.out.println(i);