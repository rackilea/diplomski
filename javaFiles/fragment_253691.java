File blub = new File("blub.txt");

    Scanner scanner = null;
    try
    {
        scanner = new Scanner(blub);
    }
    catch (FileNotFoundException e){}


    while(scanner.hasNext("((\\S*)#){6}(\\w)"))
    {
        String buffer = scanner.next("((\\S*)#){6}(\\w)");
        for(String value : buffer.split("#"))
            System.out.print(value + " ");
        System.out.println();
    }