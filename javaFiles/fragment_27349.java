private Square[,,] sheets;
public Square[,] GetSheet(int index) 
{
    int x = sheets.GetLength(0);      
    int y = sheets.GetLength(1); 

    Square[,] sheet = new Square[x,y];
    for(int i = 0; i < x; i++)
    for(int j = 0; j < y; j++)
         sheet[i,j] = sheets[i,z,index];

    return sheet;
}