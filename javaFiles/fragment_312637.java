public class Matlab {

    public static double[] sum(double[][] weights, int i) {
        double[] des;

        switch (i) {
        case 1:
            des = new double[weights[0].length];
            for (int k = 0; k < weights[0].length; k++) {

                double sum =0;
                for(int j = 0; j<weights.length;j++){
                    sum +=  weights[j][k];
                }
                des[k]=sum;

            }
            return des;

        case 2:
            des = new double[weights.length];
            for(int j = 0; j<weights.length;j++){
                double sum =0;
                for (int k = 0; k < weights[j].length; k++) {
                    sum +=  weights[j][k];
                }
                des[j]=sum;
            }
            return des;

        return null;
    }

}