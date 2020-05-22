public static List<Integer> lineUp(int maxPeople, boolean alignLeft){
        Random rand = new Random();
        int numPeople = rand.nextInt(maxPeople+1);
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i < maxPeople; i++){
            if(i < numPeople)   
                list.add(1);
            else if(alignLeft)
                list.add(0);
            else
                list.add(0,0);
        }
        return list;
    }