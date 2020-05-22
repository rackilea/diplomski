public static List<Integer> lineUpPeople(int numPeople, boolean alignLeft){
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i < numPeople; i++){
            boolean person = rand.nextBoolean();
            if(person){
                list.add(1);
            }
        }
        for(int i=list.size(); i < numPeople; i++){
            if(alignLeft)
                list.add(0);
            else
                list.add(0,0);
        }

        return list;
    }