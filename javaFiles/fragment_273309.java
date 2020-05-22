public static double add(String[] values) {
    double sum = 0.0;
    try {
        int length = values.length;
        double arrayValues[] = new double[length];
        for(int i = 0; i < length; i++) {
            arrayValues[i] = Double.parseDouble(values[i]);
            sum += arrayValues[i];
        }
    } catch(NumberFormatException e) {
        e.printStackTrace();
    } catch(RangeException e) {
        throw e;
    } finally {
        System.out.println("Thank you for using the program!");
    }
    return sum;
}