private static final int NUMBER_DICE_SIDES = 6;
public static void main(String[] args) {
    final static int TIMES_TO_ROLL = getInt("Times to roll?");
    Random flip = new Random(NUMBER_DICE_SIDES);
    int[] results = new int[NUMBER_DICE_SIDES];
    for (int i = 0; i < TIMES_TO_ROLL; i++) {
        int result = flip.nextInt;
        System.out.println(result);
        results[result]++;
    }

    for(int i = 0; i < NUMBER_DICE_SIDES; ++i) {
        System.out.println((i+1)+"'s: " + arraysCount(results, i));
    }
}

public static int arrayCount(int[] array, int item) {
    return array[item];
}