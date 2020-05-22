class a{

    public static void main(String[]args){

        final int column = 3;
        Comparable[][] a = new Comparable[][]{
            {"oranges", "orange color", 9180, 25.18},
            {"apples", "green", 9180, 16.19},
            {"strawberries", "red", 9180, 45.36},
            {"grapes", "green", 9180, 35.16}
        };

        java.util.Arrays.sort(a, 
            new java.util.Comparator<Comparable[]>(){
                public int compare(Comparable[]a,Comparable[]b){
                    return a[column].compareTo(b[column]);
                }
        });

        for (Comparable[] c : a)
            System.out.println(java.util.Arrays.toString(c));

    }

}