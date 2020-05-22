public static void calculateBMI(String name, String[] names, int[] weight, double[] height) {

    for (int i = 0; i < names.length; i++) {
        if(names[i].equalsIgnoreCase(name))
            System.out.println(weight[i] / height[i] / height[i]);
    }
}