int[] inputMove()
{
    int[] values = new int[2];
    for(;;)
    {
        // read only ROW as before
        if(0 <= values[0] && values[0] < rows)
            break;
        System.out.println("row out of range");
    }
    // now the same for COLUMN
    return values;
}