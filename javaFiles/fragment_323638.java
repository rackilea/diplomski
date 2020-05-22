ArrayList<String> lisM = new ArrayList<>();  // here I initialise the list as an array list with strings. 

    ArrayList<Boolean> booleanList = new ArrayList<>();
    for (int i = 0; i < lisM.size() / 3; i++) {
        booleanList.add(true);
    }

    for(int i = 3; i < lisM.size();i+=3) {
        int m = Integer.parseInt(lisM.get(i)); // here I changed the casting to parsing and moved it out of the for loop, there is no need to initialize it again every single time since you do not change it in the second for loop.
        for (int j = 6; j < lisM.size(); j += 6) {
            int m1 = Integer.parseInt(lisM.get(j));// here I changed the casting to parsing again.
            if (m > m1) { // this makes no sense here because you are going over all of the elements of the list and comparing them to all of them. But I kept it here for the sake of example.
                booleanList.set(i/3,false); 
            }