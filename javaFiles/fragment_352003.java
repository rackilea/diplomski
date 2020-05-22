String temp = "";

// foreach row...
for( int i = 0; i < cells.length; i++ )
{

    // ... move across columns
    for( int j = 0; j < cells[i].length; j++ )
    {

        temp += (cells[i][j] + " ");

    }

    // let's move to a new line
    temp += "\n";

}

System.out.println(temp);