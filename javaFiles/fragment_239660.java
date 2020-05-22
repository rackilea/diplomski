class Arrays{

    public static void main(String[] args){

        int array_x[][]={{9,8},{2,17},{49,4},{13,119},{2,19},{11,47},{3,73}};

        int sum=0;

        for(int i=0;i<array_x.length;i++) {
            int prod = array_x[i][0] * array_x[i][1];
            System.out.println("\n"+prod);
            sum += prod;
        }

        System.out.println("Final: " + sum);
    }
}