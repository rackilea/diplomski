public void gridEntityDidUpdate(final Point fromLocation, final Point toLocation) {
    Activity activity = getMainActivity();
    activity.runOnUiThread(
            new Runnable() {
                @Override
                public void run() {
                    updateScreen(fromLocation, toLocation);
                    if(pointsAreCoincedent(fromLocation, toLocation)) {
                        System.out.println("Hello there!");
                    }
                }
            }
    );
}

private void updateScreen(Point fromLocation, Point toLocation) {
    //Update the main activity screen here
}