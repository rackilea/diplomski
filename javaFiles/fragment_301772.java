public static void main(String[] args) {

        double d1 = 1.234567;
        double d2 = 2;
        NumberFormat nf = new DecimalFormat("##.###");
        System.out.println(nf.format(d1));
        System.out.println(nf.format(d2));
    }