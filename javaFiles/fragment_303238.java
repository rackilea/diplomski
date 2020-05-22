public static void main(String args[]) {
    String userin = "111111";
    int max = 180;

    String allofem = "";

    int a[] = {1, 2, 3, 4, 5, 12, 21};

    for (int k1 = 0; k1 < a.length; k1++) {
        for (int i = 0; i < max; i++) {
            if (i < 100) {
                String num = "" + String.format("%02d", i);
                String added = userin + a[k1] + num;
                allofem = allofem + added;

            }
            if (i >= 100) {
                int b = 0;
                while (b < 10) {
                    String added = userin + a[k1] + k + b;
                    allofem = allofem + added;
                    b++;
                }
                k++;
            }
        }
    }
    System.out.println(allofem);
}