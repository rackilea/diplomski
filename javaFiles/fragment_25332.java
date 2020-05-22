enum MONTHS {
    JANUARY, FEBRAURY...
};

public static void main(String[] args) {
    int month = 2;// read month
    System.out.println(MONTHS.values()[month - 1]);//values will convert enum to array and then you could access month name from index
}
 Output:
 FEBRAURY