public class MultidimensionalKnapsack {

    /** The size of the knapsack */
    private static int size;
    /** The volume of the knapsack */
    private static int vol;

    private static class Item {
        public int value;
        public int size;
        public int volume;
        public Item(int v, int w, int vol) {
            value = v;
            size = w;
            volume = vol;
        }
    }

    // Knapsack 0/1 without repetition
    // Row: problem having only the first i items
    // Col: problem having a knapsack of size j
    // Third dimension: problem having a knapsack of volume h
    private static int[][][] dynNoRep;

    private static void noRep(Item[] items) {
        dynNoRep = new int[items.length + 1][size + 1][vol + 1];
        for(int j = 0; j <= size; j++) {
            dynNoRep[0][j][0] = 0;
        }
        for(int i = 0; i <= vol; i++) {
            dynNoRep[0][0][i] = 0;
        }
        for(int i = 0; i <= items.length; i++) {
            dynNoRep[i][0][0] = 0;
        }
        for(int i = 1; i <= items.length; i++)
            for(int j = 0; j <= size; j++) {
                for(int h = 0; h <= vol; h++) {
                    if(items[i - 1].size > j)
                        // If the item i is too big, I  can't put it and the solution is the same of the problem with i - 1 items
                        dynNoRep[i][j][h] = dynNoRep[i - 1][j][h];  
                else {
                    if(items[i - 1].volume > h)
                        // If the item i is too voluminous, I can't put it and the solution is the same of the problem with i - 1 items
                        dynNoRep[i][j][h] = dynNoRep[i - 1][j][h];
                    else {
                        // The item i could be useless and the solution is the same of the problem with i - 1 items, or it could be 
                        // useful and the solution is "(solution of knapsack of size j - item[i].size and volume h - item[i].volume) + item[i].value" 
                        dynNoRep[i][j][h] = Math.max(dynNoRep[i - 1][j][h], dynNoRep[i - 1][j - items[i - 1].size][h - items[i - 1].volume] + items[i - 1].value);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        size = 15;
        vol = 12;
        Item[] items = {new Item(2, 4, 1), new Item(1, 5, 4), new Item(6, 3, 9), 
            new Item(3, 3, 19), new Item(7, 2, 7), new Item(1, 2, 6), new Item(2, 1, 2),
            new Item(10, 9, 12), new Item(9, 10, 2), new Item(24, 23, 11)};
        System.out.print("We have the following " + items.length + " items (value, size, volume): ");
        for(int i = 0; i < items.length; i++)
            System.out.print("(" + items[i].value + ", " + items[i].size + ", " + items[i].volume + ") ");
        System.out.println();
        System.out.println("And a knapsack of size " + size + " and volume " + vol);

        noRep(items);
        System.out.println();
        // Print the solution
        int j = size, h = vol, finalSize = 0, finalValue = 0, finalVolume = 0;
        System.out.print("Items picked (value, size, volume) for 0/1 problems without repetitions: ");
        for(int i = items.length; i > 0; i--) {
            if(dynNoRep[i][j][h] != dynNoRep[i - 1][j][h]) {
                System.out.print("(" + items[i - 1].value + ", " + items[i - 1].size + ", " + items[i - 1].volume + ") ");
                finalSize += items[i - 1].size;
                finalValue += items[i - 1].value;
                finalVolume += items[i - 1].volume;
                j -= items[i - 1].size;
                h -= items[i - 1].volume;
            }
        }
        System.out.println();
        System.out.println(" Final size: " + finalSize);
        System.out.println(" Final volume: " + finalVolume);
        System.out.println(" Final value: " + finalValue);
    }