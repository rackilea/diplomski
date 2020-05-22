public static void sherwoodSearch(int[ ] array, int value)
    {
        int first, last, middle, position, count;
        boolean found;

        //set the inital values.
        first = 0;
        last = array.length-1;
        position = -1;
        found = false;
        count =1;
        Random rand = new Random();
        //search for the value
        while (!found && first <= last)
        {
            count++;
            middle = first + rand.nextInt(last - first + 1);
            if (array[middle] == value)
            {
                found = true;
                position = middle;
            }
            else if (array[middle] > value)
                last = middle -1;
            else
                first = middle + 1;
            if (first <= last)
            {
                System.out.println("The number was found in array subscript" + position);
                System.out.println("The sherwood search found the number after " + count +
                    " comparisons.");

            }
            else
                System.out.println("Sorry, the number is not in this array.  The sherwood search made "
                    +count  + " comparisons.");
        }
    }