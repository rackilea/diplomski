for (int i = 0; i < n; i++) 
    {
        for (int j = i + 1; j < n; j++) 
        {
            if (names[i].compareTo(names[j])>0) 
            {
                temp = names[i];
                names[i] = names[j];
                names[j] = temp;
            }
        }
    }
    System.out.print("Names in Sorted Order:");
    for (int i = 0; i < n - 1; i++) 
    {
        System.out.print(names[i] + ",");
    }