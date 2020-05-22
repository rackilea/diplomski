public static void main(String[] args) {        

    String[][] data = {
            {"2018-09-03","287.5","289.8","286.15","287.3","287.65","1649749.0","4750.35"}      
            ,{"2018-08-31","286.25","290.5","285.0","285.5","285.95","3716997.0","10691.41"}
            ,{"2018-08-30","286.45","290.55","284.6","286.05","285.6","3861403.0", "11097.03"}
    };


    for(int i=0;i<data.length;i++) {
        for(int j=0;j<data[i].length;j++) {
            System.out.print(data[i][j]);
        }
        System.out.println();
    }

    // or you can print like this

    for(int i=0;i<data.length;i++) {

        System.out.println(Arrays.toString(data[i])+",");

    }
}