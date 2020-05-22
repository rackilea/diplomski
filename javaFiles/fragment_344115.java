public static void move(ABug bug){
        Scanner reader = new Scanner(System.in);
        System.out.println("Would you like this bug to move?\n 0-No,  1-Yes\n");
        if (reader.nextInt() == 0)
        {
            System.exit(0);
        }

        int r = (int) (Math.random() * (2- -2)) + -2;

        int originalHorpos = bug.horpos

        int originalVertpos = bug.vertpos

        // Now just change the attributes however you see fit. i am just adding r
        bug.horpos = originalHorpos + r;

        bug.vertpos = originalVertpos + r

        /*by the way, we dont need to use variables for the original values. something like this would also work 

           bug.horpos += r; 
           bug.vertpos += r;

 i just want to explain that in java when you pass objects, they are passed by reference and hence you have access to all of its members.

*/
        System.out.println(r);


    }