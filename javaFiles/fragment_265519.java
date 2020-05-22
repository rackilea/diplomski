int size = 2:
ArrayList<Integer[]> nums = new ArrayList<Integer[]>(size);
Integer[] value1 = {1,2,3};
Integer[] value2 = {1,2};
nums.add(0, null);
nums.add(1,value1);
nums.set(0,value2);