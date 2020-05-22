nrOfFails = 0;
ArrayList<Integer> solutions = new ArrayList<>();
int[] money1= {2,2,2,5,10,10,20};
int target = 24;
System.out.println(solutions(money1,0,target,solutions));
System.out.println ("number of fails = " + nrOfFails);