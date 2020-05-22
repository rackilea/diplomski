//the length of the first array will be the half way point which we already have
String [][] newArrayA = new String[halfWayPoint][numberOfElementsInArray];
//this copies the data over
for(int i = 0; i < halfWayPoint; i++)
{
    newArrayA[i] = array[i];
}

//now create the other array
int newArrayBLength = array.length - halfWayPoint;
String[][] newArrayB = new String[newArrayBLength][numberOfElementsInArray];
/*
 * This copies the data over. Notice that the for loop starts a halfWayPoint.
 * This is because this is where we left of copying in the first array.
 */
for(int i = halfWayPoint; i < array.length; i++)
{
    newArrayB[i] = array[i];
}