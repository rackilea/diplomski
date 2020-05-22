public class TestArrays {

    public static void main(String[] args) {
        List<int[]> listOfValues = new ArrayList<int[]>();
        int[] outter = new int[] {1, 2, 3, 4};

        listOfValues.add(outter);
        dump(outter);
        for (int index = 0; index < 5; index++) {            
            int[] inner = new int[] {
                rand(),
                rand(),
                rand(),
                rand()
            };
            outter = inner;
            dump(outter);
            listOfValues.add(outter);            
        }

        int index = 0;
        for (int[] values : listOfValues) {
            System.out.print("[" + index + "] ");
            dump(values);
            index++;
        }

    }

    public static void dump(int[] values) {
        for (int value : values) {
            System.out.print(value + ", ");
        }
        System.out.println("\b\b"); // Cheeck...;)
    }

    public static int rand() {
        return (int)Math.round(Math.random() * 100);
    }

}