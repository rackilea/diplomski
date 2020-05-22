Circle c1 = null;
    do
    {
        System.out.println ("==== Circle Computation =========");
        System.out.println ("| 1. Create a new circle\t|");
        System.out.println ("| 2. Print area\t\t\t|");
        System.out.println ("| 3. Print circumference\t|");
        System.out.println ("| 4. Quit\t\t\t|");

        System.out.println ("Choose option (1 - 3): ");
        choice = in.nextInt();
        if (choice == 1)
        {
            System.out.println ("Enter the radius to compute the area & circumference:");
            user_input = in.nextInt();              

            c1 = new Circle(user_input);     //refer to prob @ choice '2'
            System.out.println ("A new circle is created.\n");
        }

        if (choice == 2)
        {           
            //Prob - instance 'c1' & var 'user_input' @ choice '1' not visible in other if-else statements?
            //http://stackoverflow.com/questions/11685023/creating-an-instance-of-an-object-within-an-if-in-c-sharp
            System.out.println ("Area of circle:");
            System.out.println ("Radius: " + c1.getRadius());
            System.out.println ("Area: " + c1.area());
        }           
    }