List<Integer> result = new ArrayList<Integer>();
System.out.print("Odd numbers:");
for (int i = 0; i < lengthOfArray; i++) {
    if (a[i] % 2 != 0) {
  result.add(a[i]);
        System.out.print(a[i] + " ");
    }
}