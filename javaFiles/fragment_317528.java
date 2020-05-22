protected void onDraw(Canvas canvas) {
    if (canvas != null) {
        c = canvas;
        super.onDraw(canvas);
        if (bg) {
            if (mbg != null) {
                mbg.draw(canvas);
            } else {
                /*
                 * Handle null value
                 * print to logcat this was null
                 */
            }
        }
        for (int i = 0; i < 102; i++) {
            if (wall[i] != null) {
                wall[i].draw(c);
            } else {
                /*
                 * Handle null value
                 * print to logcat this was null
                 */
            }
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (block[i][j] != null) {
                    block[i][j].draw(canvas);
                } else {
                    /*
                     * Handle null value
                     * print to logcat this was null
                     */
                }
            }
        }
        //Actually draw
        invalidate();
    } else {
        /*
         * Handle null value
         * print to logcat this was null
         */
    }

}