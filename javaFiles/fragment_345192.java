int[] array = new int [6]; 

// Size of the array is 6, so array.length returns 6
// Which also means that valid cells are from 0 to 5 inclusively.

// Here we say, for i that starts at 0, as long as i is smaller than 6 (your array
// length, perform the body of the loop. Everytime you do it, increase i by 1.

for ( int i = 0 ; i  < array.length ; i++ ) 
{
      array [i] = i*i; 
}


//This does the following:
// array[0] = 0*0; -> array[0] = 0;
// array[1] = 1*1; -> array[1] = 1;
// array[2] = 2*2; -> array[2] = 4;
// array[3] = 3*3; -> array[3] = 9;
// array[4] = 4*4; -> array[4] = 16;
// array[5] = 5*5; -> array[5] = 25;
// and the loop stops.

//Now the second loop: same thing as the first loop but we increase i by 2 instead of 1

for ( int i = 0 ; i  < array.length ; i = i + 2 )
{
      array[i] = array[i] + array[ i + 1 ];
}

// This does the following:
// array[0] = array[0] + array[0+1] -> array[0] = 0 + 1; -> array[0] = 1;
// array[2] = array[2] + array[1+1] -> array[2] = 4 + 9; -> array[2] = 13
// array[4] = array[4] + array[4+1] -> array[4] = 16 + 25 -> array[4] = 41
// And we stop because i=4, so i= i+2 = 6, which is larger than array.length (5)