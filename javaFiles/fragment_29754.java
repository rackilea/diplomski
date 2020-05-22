String[][] clientsArray = new String[20][4];
int rows = 20; // this can also be clientsArray.length
int columns = 4; // this can also be clientsArray[0].length

for (int r = 0; r < rows ; r++ )
{
    //since you are only looking at the 1st column, you don't need the inner loop
       // this makes sure that the spot in the 2d array is set, otherwise trying to call .equals will crash your program.
       if (clientsArray[r][0] == null || clientsArray[r][0].equals ("0")) 
       {
          String key = Integer.toString(r);
          clientsArray[r][0] = key;
          clientsArray[r][1] = "a"
          clientsArray[r][2] = "b"
          clientsArray[r][3] = "c"   //you don't need the 0+, if you wanted to have a 2d array with more then 4 rows, you could put a for loop here insead of doing it 4 times like you did here
          break; //if you wanted to find ALL empty rows take this out.
          //also note if you have 2 loops like in your question, if would only break out of the 1st one
       }   
}