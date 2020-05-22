public static void main(String args[]){
        List<Integer[]> subSet = new ArrayList<Integer[]>();
        subSet.add(new Integer[]{0,1,2,3,4});
        subSet.add(new Integer[]{0,1,2,3,5});
        subSet.add(new Integer[]{0,0,0,0,0});
        //prune this collection by removing an Integer[] 
        Integer[] elementToRemove = {0,0,0,0,0};
        System.out.println( "Before " + subSet.size());

        //get your Integer[] iterator
        Iterator<Integer[]> it = subSet.iterator();
        //for each element in the array
        while(it.hasNext()){

            //check if it is equal to the elementToRemove
            if(Arrays.equals(it.next(), elementToRemove)){
                //remove it
                it.remove();
            }                   
        }
        System.out.println( "After " + subSet.size());
    }