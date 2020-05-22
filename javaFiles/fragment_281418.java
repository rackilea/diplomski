for (int s=0; s<stories; s++)
{
    printTopRowOfStory(totalBuildingWidth);        // ***********
    printWalls(totalBuildingWidth);                // *         *
    printWindowBorders(windows, wide);             // * *** *** *
    for (int h=0; h<tall; h++)          
    {                                              
        printInnerWindowBorders(windows, wide);    // * * * * * *
    }
    printWindowBorders(windows, wide);             // * *** *** *
    printWalls(totalBuildingWidth);                // *         *
}
printFloor(totalBuildingWidth);                    // ***********