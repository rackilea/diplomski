public static void printArray(int[] noclue, String[] name, double[] age, double[] salary, double[] insurance,
        double[] expense, double[] savings) {
    for (int i = 0; i < noclue.length; i++) {
        System.out.println(noclue[i] + " " + name[i] + " " + age[i] + " " + salary[i] + " " + insurance[i]);
    }
}