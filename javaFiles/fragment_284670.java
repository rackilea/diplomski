for(int i=0;i<matrix_length;i++)
{
    for(int j=0; j<matrix_length;j++)
    {
        String[] temp=input1[i].split("#");
        int first=Integer.parseInt(temp[0])-1;
        int second=Integer.parseInt(temp[1])-1;
        matrix[first][second]="1";
        matrix[second][first]="1";
    }
}