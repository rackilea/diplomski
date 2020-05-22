public static void main(String []args){
        //Create ArrayLists
        String[] A1 = {"Rettangolo", "Quadrilatero", "Rombo", "Quadrato"};
        ArrayList<String> a1=new ArrayList(Arrays.asList(A1));
        String[] A2 ={"Rettangolo", "Rettangolo", "Rombo", "Quadrato"};
        ArrayList<String> a2=new ArrayList(Arrays.asList(A2));
        // Check ArrayLists
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        // Find difference
        for( String s : a1)
            a2.remove(s);
        // Check difference
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
}