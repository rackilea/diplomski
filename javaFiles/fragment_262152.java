public static void calculateWeight(String name, String[] names, int[] weight, double[] height) {

    for (int i = 0; i < names.length; i++) {
        if (names[i].equalsIgnoreCase(name)) {
            double perfectWeight = ((height[i] * 100) - 100) - (((height[i] * 100) - 100) / 10);
            System.out.println("Perfect weight for that height is : " + perfectWeight);
            if(weight[i] == perfectWeight)
                System.out.println("Person has perfect weight");
            else if(weight[i] > perfectWeight)
                System.out.println("Person should lose: " + (weight[i] - perfectWeight));
            else
                System.out.println("Person should gain: " + (perfectWeight - weight[i]));
        }

    }
}