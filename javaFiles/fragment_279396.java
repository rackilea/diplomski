public int compare(Object o1, Object o2)
    {
        int result = 0;

        if ((o1 != null) && (o2 != null))
        {
            if (o1 instanceof Item && o2 instanceof Item)
            {
                Item lmi1 = (Item) o1;
                Item lmi2 = (Item) o2;

                if ((lmi1.getName() != null) && (lmi2.getName() != null))
                {
                    if(lmi1.getName().endsWith("Paid") 
                       && lmi2.getName().endsWith("Free")) 
                    {
                         result = 1;
                    }
                    else if (lmi1.getName().endsWith("Free") 
                       && lmi2.getName().endsWith("Paid"))
                    {
                         result = -1;
                    }
                    else
                    {
                         result = lmi1.getName().compareToIgnoreCase(lmi2.getName());

                    }

                                        }
            }
        }
        return result;
    }