public static void iterate(int[] previousValues, int[] tabs) {
    if (tabs.length == 0) {
        System.out.println(Arrays.toString(previousValues));
    }
    else {
        final int[] values = new int[previousValues.length + 1];
        for (int i = 0; i < previousValues.length; i++) {
            values[i] = previousValues[i];
        }
        final int[] nextTabs = new int[tabs.length - 1];
        for (int i = 0; i < nextTabs.length; i++) {
            nextTabs[i] = tabs[i + 1];
        }
        for (int i = 0; i < tabs[0]; i++) {
            values[values.length - 1] = i;
            iterate(values, nextTabs);
        }
    }
}
public static void iterate(int[] tabs) {
    iterate(new int[0], tabs);
}