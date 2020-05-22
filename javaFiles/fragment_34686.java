public class BubParArrays {
    public static void main(String[] args) {
        int saleUnits[] = {5, 12, 5, 7, 8};
        double salePrices[] = {2.5, 12.0, 0.25, 0.7, 8.0};
        int pass, comparison, tempsaleunit;
        double tempsaleprice;
        String results = "";

        for (pass = 0; pass < saleUnits.length; pass++) {
            for (comparison = 1; comparison <= saleUnits.length-1; comparison++) {
                if (saleUnits[comparison - 1] < saleUnits[comparison]) {
                    System.out.println("If saleUnits[ " + (comparison - 1) + " ]  <  salesUnits  [ " + comparison + "] \n ");

                    tempsaleunit = saleUnits[comparison - 1];
                    System.out.println("tempsaleunit \t" + tempsaleunit + " = saleUnits [ " + (comparison) + " ]");

                    saleUnits[comparison - 1] = saleUnits[comparison];
                    System.out.println(" saleUnits [ " + (comparison - 1) + " ]" + " = saleUnits [ " + (comparison) + " ]");

                    saleUnits[comparison] = tempsaleunit;
                    System.out.println(" saleUnits[ " + comparison + " ] " + " =  tempsaleunit " + tempsaleunit);

                    tempsaleprice = salePrices[comparison - 1];
                    System.out.println(" tempsaleprice \t" + tempsaleprice + " =  salePrices [ " + (comparison - 1) + "]");

                    salePrices[comparison - 1] = salePrices[comparison];
                    System.out.println(" salePrices[ " + (comparison - 1) + " ] = salePrices [ " + (comparison) + "]");

                    salePrices[comparison] = tempsaleprice;
                    System.out.println(" salePrices [ " + comparison + "] =  tempsaleprice  " + tempsaleprice + "\n");
                }
            }
        }

        for (int index = 0; index < (saleUnits.length); index++) {
            results = results + saleUnits[index] + "," + salePrices[index] + "\n";
        }
        System.out.print(" Sorted on units of sale \n" + results);
    }
}