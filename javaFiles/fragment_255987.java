for(int i=0; i<determinedDungeonSize ;i++)
    {
        //just move these to the inside of the loop
        //so they are fresh each time
        String cell = ("|____|   ");
        char[] cellArray = cell.toCharArray();

        int randomProbability = r.nextInt(10000);

        if(randomProbability < 5000)
        {
            cellArray[2] = 'M';
        }

        if(i == weaponRandom)
        {
            if(randomProbability < 5000)//this does mean that if the weapon is in the same room as a monster, it will always be Sw. Consider generating a new random value
            {
                cellArray[3] = 'S';
                cellArray[4] = 'w';
            }
            else
            {
                cellArray[3] = 'S';
                cellArray[4] = 't';
            }

        }//end if

        cell = String.valueOf(cellArray);
        dungeon.add(cell);
    }//end for