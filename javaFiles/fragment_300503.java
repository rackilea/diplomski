// at this point you only have a matrix: your `int a2[][]`
// and the List will only exist for the shuffling
// lets say that WIDTH HEIGHT exist and are int constants

List<Integer> tempList = new ArrayList<Integer>(WIDTH*HEIGHT);
for (int i=0; i<HEIGHT; i++)
   for (int j=0; j<WIDTH; j++)
      list.add(a2[i][i]);

// now your integers are in the list and you can shuffle them
Collections.shuffle(tempList);

// now give the numbers back to the matrix (as on your previous code)
for (int i=0; i<HEIGHT; i++)
   for (int j=0; j<WIDTH; j++)
      a2[i][i] = list.get(i*WIDTH+j);

// and you can forget your tempList