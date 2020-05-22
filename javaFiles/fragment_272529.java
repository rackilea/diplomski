List<Integer> drawn = ...
int[] count = new int[60];
for (int draw : drawn)
     count[draw]++;
for (int i = 1; i < count.length; i++)
     System.out.println(i + ": " + count[i]);