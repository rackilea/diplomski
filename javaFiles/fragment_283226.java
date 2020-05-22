for(Integer i = 0; i < 10; i++)
     {
        Integer r = (int)(Math.random() * 10) + 1;
        for (Integer j = 0; j <= list.size() - 1; j++)
        {
            if (list.get(j) == r)
            {
                remove = j + 1;
                list.remove(remove);//the main error is here you found 4 
                                    //on index 2 and removes 3 (because of +1)
                perm.add(r);
            }
        }
    }