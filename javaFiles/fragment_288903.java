public static void main(String... args) {
    double avg = 0.90;
    List<Double> list = new ArrayList<>();
    list.add(0.8503);
    list.add(0.89);
    list.add(0.90);
    list.add(0.9488);

    list.add(0.8309); // this will fail;
    list.add(0.849999); // this will fail;
    list.add(0.95001); // this will fail;

    int inRangeRate = 0;
    for (Double aDouble : list) {
        if (Math.abs(avg - aDouble) < 0.05) {
            inRangeRate++;
        }
    }
    System.out.println("In Range Count: " + inRangeRate);
}