Place(x)

  // Here x is the column number where you want to put the queen
  if (x == board_size + 1):
      print (array A)
      return;
  for y from 0 to board_size:
       if (!underattack(A,x,y)) // A[x] = y => the queen is at row y in col x
            A[x] = y
            Place(x+1)
  return;