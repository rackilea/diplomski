int xSize = 3;// 
int[] ySizes = {1, 2, 3};// sizes for y
int[] zSizes = {1, 2, 3, 5, 6, 7};
//             [ ] [   ] [      ]

int[][][] array3d = new int[xSize][][];// pre-initialize x 

for (int x = 0; x < array3d.length; x++)
    array3d[x] = new int[ySizes[x]][];// set the sizes of y

int pos = 0;
for (int x = 0; x < array3d.length; x++)
    for (int y = 0; y < array3d[x].length; y++)
        array3d[x][y] = new int[zSizes[pos++]];// set the sizes of z


// fill the array with some test values
for (int x = 0; x < array3d.length; x++)
    for (int y = 0; y < array3d[x].length; y++)
        for (int z = 0; z < array3d[x][y].length; z++)
            array3d[x][y][z] = x * y * z;

// print the array
System.out.println(
        Arrays.deepToString(array3d)
                .replace("],", "],\n ")
                .replace("]],", "]],\n"));
// the call to replace just improves readability