LinkedList<example> ob = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Press y to Continue n to Exit");
        char i = input.next().charAt(0);
        while(i!='n')
        {
            input.nextLine();
            System.out.println("Enter name");
            String name = input.nextLine();
            System.out.println("Enter value");
            int value = input.nextInt();
            input.nextLine();
             System.out.println("Enter city");
            String city = input.nextLine();
            ob.addLast(new example(name,value,city));
            System.out.println("Press y to Continue n to Exit");
             i = input.next().charAt(0);
        }