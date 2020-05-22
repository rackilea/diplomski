//maps will hold ALL unique integer as it's key
HashMap<Integer, ArrayList<Integer>> maps = new HashMap<Integer, ArrayList<Integer>>();

//your initial array, written inline for clarity
ArrayList<Integer> parentarraylist = new ArrayList<Integer>(Arrays.asList( new Integer[] {1,1,1,2,3,2,3,3,2,2,1}));

//get the iterator so that we won't need another temporary int variable for loop
Iterator<Integer> iterator = parentarraylist.iterator();
while(iterator.hasNext()){
    //next = current integer in our array
    Integer next = iterator.next();

    //check if we have already have current integer or not
    if(!maps.containsKey(next)){
        //we don't have it, initialise an arraylist for this specific integer
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(next);

        //put it to our map holder
        maps.put(next, x);
    } else {
        //already have it, add directly
        maps.get(next).add(next);
    }
}