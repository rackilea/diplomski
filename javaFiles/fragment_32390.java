public void displayArray()
{
    for(int i = 0 ; i < names.length ; i++)
    {
        /*
         *  If the first or last name are null then skip over and go to the 
         *      next item
         */
        if(names[i][0] == null || names[i][1] == null)
        {
            continue;
        }

        for(int j = 0; j < firstNLast; j++)
        {
            finalOutput.append(
                String.format("%10s%s%10s%s", 
                        names[i][j], " ", marks[i][j], " "));
        }

        finalOutput.append("\n");
    }
}