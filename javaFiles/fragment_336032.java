public static void main(String[] args) {
        GregorianCalendar data1 = new GregorianCalendar(2015, 1, 4, 11, 10);
        GregorianCalendar data2 = new GregorianCalendar(2015, 1, 4, 11, 20);
        double b = (data2.getTimeInMillis() - data1.getTimeInMillis()) / (1000.0 * 3600.0);
        System.out.println(b);
        int k = (int) Math.ceil(b);
        System.out.println(k);
    }