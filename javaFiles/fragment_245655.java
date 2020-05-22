public void remove()
    {
        in = new Scanner(System.in);
        System.out.print("Please enter the destination name to be removed: ");
        nameSearch = in.nextLine();
        for(i=0; i < MAX_ELEMENT; i++)
        {
            // we skip removed destination from previous remove() call
            if(aDestination[i]==null) continue;

            temp = aDestination[i].getName;
            // you need to use equals() to compare String in Java
            if(temp.equals(nameSearch))
            {
                aDestination[i]=null;
                break; // to exit from the loop
            }
        }
    }