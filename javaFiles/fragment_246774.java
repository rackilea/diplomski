void mirrorHorizontally()
{
    char[][]horizontalImage = new char[horizontalImage.length][horizontalImage[0].length]; // assumes all lines have same length


    for (int i = 0; i < height /2; i++)
    { 
       for(int j = 0; j < width; j++)
       {            
           horizontalImage[height - (i+1)][j] = canvasArray[i][j];           
           horizontalImage[i][j] = canvasArray[height - (i+1)][j];
       }
    }

    printPicture(horizontalImage);
}