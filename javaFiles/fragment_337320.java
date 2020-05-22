class Roll {
    int first;
    int second;
    int total;

    public Roll(int first, int second) {
        this.first = first;
        this.second = second;
        this.total = first + second;
     }

 List<Roll> permutations = new ArrayList<>();
 for (int ii = 1; ii < 7; ii++)
     for (int jj = 1; jj < 7; jj++)
         permutations.add(new Roll(ii,jj);

 roll the dice, determine the total;
 now loop through the permutations to find the 
   total matching the roll total. These are your combinations. 
   This solution doesn't handle duplicate rolls. For example 1,6 and 6,1;