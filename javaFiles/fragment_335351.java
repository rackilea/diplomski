while(sc.hasNextLine()){
    command = sc.nextLine();
    temp = command + " Dat dus";
    PrintStream p = new PrintStream(ss.getOutputStream());
    p.println(temp);
    }