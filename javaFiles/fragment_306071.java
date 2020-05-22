public class UniqueFactors {
    public static void main(String[] args) {
        int input = 12; // Currently, the output is blank if the input is 1
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

        for (int i = 2; i <= input; i++) {
            int result;
            if (input % i == 0) {
                result = input / i;
                ArrayList<Integer> factorSet = new ArrayList<>();
                factorSet.add(i);
                boolean moreFactors = false;
                int result2 = result;
                for (int j = 2; j <= result2; j++) {
                    if (result2 % j == 0) {
                        moreFactors = true;
                        factorSet.add(j);
                        result2 = result2 / j;
                        j = 1; // Reset to one because it will be added to on the next iteration
                    }
                }
                if (!moreFactors) factorSet.add(result);
                //> The following chunk just gets rid of duplicate combinations that were in different orders
                boolean copy = false;
                for (int k = 0; k < combinations.size(); k++) {
                    if (combinations.get(k).size() == factorSet.size()) {
                        Collections.sort(combinations.get(k));
                        Collections.sort(factorSet);
                        if (combinations.get(k).equals(factorSet)) {
                            copy = true;
                            break;
                        }
                    }
                }
                if (!copy) combinations.add(factorSet);
            }
        }

        for (int i = 0; i < combinations.size(); i++) {
            System.out.println(combinations.get(i));
        }
    }
}