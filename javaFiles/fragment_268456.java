/*
     * I changed the return type to double.
     * And if (x == 1) return; To if (x == 1) return 0;
     */
    public static double specialRecursiveFunction(int x){
        if (x == 1) return 0;
        else if (x%2==1)
            return 1 + specialRecursiveFunction(x-1);
        else
            return 1 + specialRecursiveFunction(x/2);
    }

    public static double reportOnValues(MyListOfInts m){
        if (m == null) return 0;
        else 
            return specialRecursiveFunction(m.firstInt) + reportOnValues(m.restOfTheInts);
    }