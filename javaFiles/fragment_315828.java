double max = m[0][0];
double min =  m[0][0];

//declare variables to track the indices of the min and max
int maxIndex1 = -1;
int maxIndex2 = -1;
int minIndex1 = -1;
int minIndex2 = -1;

System.out.println("The matrix is : ");
for(int i = 0; i < m.length; i++)
{
    for ( int j = 0; j < m[i].length; j++ )
    {
        System.out.printf("   " + "%6.1f " , m[i][j]);
        if (m[i][j] > max)
        {
            max = m [i][j]; 
            //record the indices of the new max
            maxIndex1 = i;
            maxIndex2 = j;  
        }  
        else if (m[i][j] < min)
        {
            min = m [i][j];
            //record the indices of the new min
            minIndex1 = i;
            minIndex2 = j;
        }