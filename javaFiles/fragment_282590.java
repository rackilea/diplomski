int[][] states = new int[][] {
        new int[] { android.R.attr.state_focused}, // enabled
        //new int[] {-android.R.attr.state_enabled}, // disabled
        //new int[] {-android.R.attr.state_checked}, // unchecked
        new int[] { android.R.attr.state_window_focused}  // pressed
};

int[] colors = new int[] {
        Color.GREEN,
        //Color.BLUE,
        //Color.YELLOW,
        Color.GRAY
};

ColorStateList myColorAccentList = new ColorStateList(states, colors);