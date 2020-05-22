for (int i = 0; i < 3; i++)
{
    for (int j = 0; j < 2; j++)
    {
        ExampleArray[i][j] = i * j;
        System.out.print(ExampleArray[i][j] + ' '); //You can replace ' ' by '\t', if
                                                      //you want a tab instead of a space
    }   
    System.out.println("");
}