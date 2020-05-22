public class AverageElements {
    private static double[][] array;

    public static void main (String[] args){

        //  Initialize array
        initializeArray();

        //  Calculate average
        System.out.println(getAverage());
    }   

    private static void initializeArray(){
        array = new double[5][2];
        array[0][0]=1.1;
        array[0][1]=12.3;
        array[1][0]=3.4;
        array[1][1]=5.8;
        array[2][0]=9.8;
        array[2][1]=5.7;
        array[3][0]=4.6;
        array[3][1]=7.45698;
        array[4][0]=1.22;
        array[4][1]=3.1478;
    }

    private static double getAverage(){
        int counter=0;
        double sum = 0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                sum = sum+array[i][j];
                counter++;
            }
        }

        return sum / counter;
    }
}