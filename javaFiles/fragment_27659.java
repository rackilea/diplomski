ArrayList<Integer> array = new ArrayList<Integer>();
        int[] intArray;
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while(a != -1)
        {
            System.out.println("Please enter an integer -1 to quit: ");
            a = scanner.nextInt();
            if(a != -1)
            {
                array.add(a);
            }
        }
        intArray = new int[array.size()];
        for(int i = 0; i < array.size(); i++)
        {
            intArray[i] = array.get(i);
        }
        for(int b = 0; b < intArray.length; b++)
        {
            System.out.println("Integer" + b + ": " + intArray[b]);
        }