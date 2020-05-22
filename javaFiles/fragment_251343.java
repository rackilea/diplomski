ArrayList<Integer> al = new ArrayList<Integer>(); 
    Random rand = new Random();
    int lineNumber = 1;
    int lineLength = 0;
    while(lineNumber < 400){
        for (int randCount = 0; randCount < lineLength; randCount++) {
            int pick = rand.nextInt(100);
            al.add(pick);
        }
        lineLength++;
        lineNumber++;
        System.out.println("Contents of al: " + al);
        al.clear();
        System.out.print("Array has been cleared: " + al);
    }