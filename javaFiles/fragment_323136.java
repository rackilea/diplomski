public int findWaitingPosition (Patient patient)
{
    int position = -1;
    for (int i=0 ; i <= waitingList.length-1 ; i++)
    {
        if (waitingList[i].equals(patient))
        {
            position = i;
            break;
        }
    }
    if (position >= 0)
        System.out.println ("The patient is on waiting list: " + i+1);
    else
        System.out.println ("Your patient is not on the waiting list");

    return position;
 }