public static void main(String[] args) {
    Month m;
    // Set the month number to the values 0 through 12 // (0 is invalid), and display the resulting month name.
    for (int i = 0; i <12; i++) {
        m = new Month();
        m.setMonthNumberInt(i);
        System.out.println("Month " + m.getMonthNumberInt() + " is " + m);
    }
    }