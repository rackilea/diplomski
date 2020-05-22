public class Data {
    private int[] values = {25,14};

    public int[] getValues() {
        return values;
    }

    public static void main(String[] args) {
        Data d = new Data();
        System.out.println(d.getValues()[0]);

        int[] values = d.getValues();
        values[0] = 15;

        System.out.println(d.getValues()[0]);

    }
}