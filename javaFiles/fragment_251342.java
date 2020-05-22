ArrayList<Integer> al = new ArrayList<Integer>(); 
    Random rand = new Random();
    int val=1;
    int ii =0;
    while(val < 400){
        for (int j = 0; j<ii; j++) {
            int pick = rand.nextInt(100);
            al.add(pick);
        }
        ii++;
        val++;
        System.out.println("Contents of al: " + al);
        al.clear();
        System.out.print("Array has been cleared: " + al);
    }