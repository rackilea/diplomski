List<Integer> numbers = new ArrayList<Integer>();
 for (int i=1; i<=n*n; i++) numbers.add(i);
 Collections.shuffle(numbers);

 int [][] magic = new int [n][n];

 int index = 0;
 for (int row = 0; row < magic.length; row++)
 {
    for(int col = 0; col < magic[row].length; col++)
        magic[row][col] = numbers.get(index++);
 }