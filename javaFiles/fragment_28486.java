/**
 * A static class, which handles all player progress, throughout the lifespan of the app.
 *
 */
static class PlayerProgress {
    // We set progress to static, so it would be alive, no matter what activity you're in.
    private static int progress = 1;

    /**
     * Update the player's progress.
     * @param levelNumber: latest level number.
     */
    public static void updateProgress(int levelNumber) {
        progress = levelNumber;
    }

    /**
     * Get the player's progress.
     * @return the latest level number.
     */
    public static int getPlayerProgress() {
        return progress;
    }
}

/**
 * The gui handler would need to be called, every time you need to update the screen to the
 * appropriate level and it's assets. (Buttons, activities ect.)
 * 
 * I would implement a MainActivity, which would handle the different screens. 
 *
 */
class guiHandler {
    public void updateLevel() {
        int progress = PlayerProgress.getPlayerProgress();
        /*
         * Add your 
         */
        switch(progress) {
        case 1:
            /*
             * Add the code, which would display level one. 
             * This would include all button visibilities and maybe load level resources ect.
             */
            break;
        case 2:
            /*
             * Same as above.
             */
            break;

        // You can expand this to as many levels you'd like. 
        }
    }
}