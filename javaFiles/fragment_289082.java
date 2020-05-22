private static ColorStateList createColorStateList(int defaultColor, int selectedColor) {
        int[][] states = new int[2][];
        int[] colors = new int[2];
        int i = 0;
        states[i] = SELECTED_STATE_SET;
        colors[i] = selectedColor;
        int i = i + 1;
        states[i] = EMPTY_STATE_SET;
        colors[i] = defaultColor;
        ++i;
        return new ColorStateList(states, colors);
    }