public class Array_2D {
    static final class Item {
        final String str;
        final int val1;
        final int val2;

        Item(String str, int val1, int val2) {
            this.str = str;
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    private static List<Item> readFile(Reader reader) throws IOException {
        try (BufferedReader in = new BufferedReader(reader)) {
            List<Item> content = new ArrayList<>();
            String str;

            while ((str = in.readLine()) != null) {
                String[] parts = str.split(" ");
                content.add(new Item(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }

            return content;
        }
    }

    private static void FivebyThree(List<Item> content) {
        StringBuilder buf = new StringBuilder();
        int sum1 = 0;
        int sum2 = 0;

        for (Item item : content) {
            // TODO do what you want with item.str
            sum1 += item.val1;
            sum2 += item.val2;
        }

        System.out.println("str: " + buf);
        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
    }


    public static void main(String[] args) throws IOException {
        List<Item> content = readFile(new InputStreamReader(Array_2D.class.getResourceAsStream("data.txt")));
        FivebyThree(content);
    }
}