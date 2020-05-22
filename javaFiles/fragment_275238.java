//Create two new arrays for testing the equals() method
int[] grades = new int[100];
int[] grades2 = new int[100]; 

for ( int i = 0; i <= grades.length-1; i++ )
{
    int value = (int) Math.floor(Math.random()*101);
    grades[i] = value;
    grades2[i] = value;
}