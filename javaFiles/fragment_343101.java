int[] ary = { 2, 1, 0, -2, -5 };

List<Integer> intList = new ArrayList<Integer>();
for (int index = 0; index < ary.length; index++) { 
  intList.add(ary[index]);
} 

intList.sort((Integer i1, Integer i2) -> Math.abs(i2) - Math.abs(i1));

System.out.println(intList);