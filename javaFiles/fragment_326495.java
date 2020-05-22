ArrayList nums = new ArrayList<Integer>(); // The arraylist with numbers from 1-10
for(int i = 1; i < 11; i++;)
    nums.add(i);

Random r = new Random();
int x = r.nextInt(10);

int[] finalNums = new int[2];
finalNums[0] = nums.get(x);
nums.remove(x); // Remove the number at this index so it won;t be picked up again

x = r.nextInt(9); // Since we removed one index from arraylist, so total elements are now nine instead of 10.
finalNums[1] = nums.get(x);
nums.remove(x);