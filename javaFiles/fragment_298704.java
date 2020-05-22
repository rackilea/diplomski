... else if(row > 1 && col != pTriangle[row].length-1)                      //Values in between first and last calculated from the two above them, to left and right.
            {
                pTriangle[row][col] = (pTriangle[row-1][col-1]) + (pTriangle[row-1][col+1]);

            }

// else missing
=========>  if (col < pTriangle[row].length)    //Move over and give values to indexes recursively until end of row is reached
            {
                populateT(row, col+1);          //Recursive call here.

            } ...