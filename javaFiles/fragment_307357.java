public static void ar() {

    double[] grades = new double[10];
    Scanner kb = new Scanner(System.in);

    for(int i=0; i < grades.length; i++)
        grades[i]=kb.nextDouble();

    double sum=0;

    for(int j=9; j >= 0; j--) //Note here that we've changed our condition. It was running zero times before. Additionally it now runs from 9-0, since the last index is 9
        sum=sum+grades[j];

    //Look out for Integer Arithmetic!
    double ave = sum/10.0;

    System.out.println(ave);
}