void display(int dimension) 
{
    int lineNumber = 0, linePosition = 0;
    int numberOfLines = dimension, numberOfCharactersPerLine = dimension;

    for(lineNumber =1;lineNumber<=numberOfLines ; lineNumber++)
    {
         for(linePosition = 1;linePosition <= numberOfCharactersPerLine ;linePosition++)
         {
             if ( linePosition < lineNumber ) {
                 System.out.print(lineNumber);
             } else {
                 System.out.print(linePosition);
             }
         }
         System.out.println();
    }
}