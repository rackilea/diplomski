class Length {

    //Declare the map as class variable
    static Map<String, Double> table = new HashMap<>();

    //Initialize the map
    static {
        table.put("mm", 0.001);
        table.put("cm", 0.01);
        table.put("dm", 0.1);
        table.put("m", 1.0);
        table.put("hm", 100.0);
        table.put("km", 1000.0);
        table.put("ft", 0.3034);
        table.put("yd", 0.9144);
        table.put("mi", 1609.34);
    }

    public static double convert(double value, String from, String to) {

        double from_value = table.get(from);
        double to_value = table.get(to);
        double result = from_value / to_value * value;

        return result;
    }

    //Print the KeySet
    public static void printMap() {
        System.out.println(table.keySet());
    }
}