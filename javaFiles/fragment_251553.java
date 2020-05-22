do
        {
            for (int j = 1; j < list.size(); j++)
            {
                System.out.println(list.get(0) + " and " + list.get(j));
            }
            list.remove(0);
        }
        while (list.size() != 0);