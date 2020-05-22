void mousePressed() 

    {
       Set<Integer> mySet = new HashSet<Integer>();
    for(int i=0;i<5;i++)
    {
        int temp = generateRandomNumber();
        //System.out.println(temp);
        mySet.add(temp);
    }
    System.out.println(mySet);
    }