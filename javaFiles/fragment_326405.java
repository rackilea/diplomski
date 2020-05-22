public static void menu() {
        int option;
        boolean sleeping = false;
        do{
            out.println("1. Sing");
            out.println("2. Eat");
            out.println("3. Sleep");
            out.println("4. Wake up");
            out.println("6. Out");
            option=Integer.parseInt(in.readLine());
            sleeping = selOption(option, sleeping);
        } while (option != 6);
    }

public static boolean selOption (int option, boolean sleeping) {
        switch (option){
            case 1:
                if(!sleeping) objectVariable.sing();
                return sleeping;
            case 2:
                if(!sleeping) eat();
                return sleeping;
            case 3:
                sleep();
                return true;
            case 4:
                wakeUp();
                return false;
            default:
                return sleeping;
        }
    }