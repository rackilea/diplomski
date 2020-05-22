String[] arr = new String[5];
        int[] arr1 = new int[5];

        Scanner kb = new Scanner(System.in);
        for(int i = 0; i<5; i++)
        {
            System.out.println("Enter a name:");
            arr[i] = kb.nextLine();
            System.out.println("Enter an ID:");
            arr1[i] = kb.nextInt();
            kb.nextLine();  //now this swallows new line
        }