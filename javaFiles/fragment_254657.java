/**
 *
 * @author alaaabuzaghleh
 */
public class TestCI {
    public static void main(String[] args) { 
        int maximumNumber = 100000;
        int num = 0;
        double[] data = new double[maximumNumber];

        // first pass: read in data, compute sample mean
        double dataSum = 0.0;
        while (num<maximumNumber) {
            data[num] = num*10;
            dataSum  += data[num];
            num++;
        }
        double ave = dataSum / num;


        double variance1 = 0.0;
        for (int i = 0; i < num; i++) {
            variance1 += (data[i] - ave) * (data[i] - ave);
        }
        double variance = variance1 / (num - 1);
        double standardDaviation= Math.sqrt(variance);
        double lower = ave - 1.96 * standardDaviation;
        double higher = ave + 1.96 * standardDaviation;

        // print results
        System.out.println("average          = " + ave);
        System.out.println("sample variance  = " + variance);
        System.out.println("sample standard daviation    = " + standardDaviation);
        System.out.println("approximate confidence interval");
        System.out.println("[ " + lower + ", " + higher + " ]");
}
}