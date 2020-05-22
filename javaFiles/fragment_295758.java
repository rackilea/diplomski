final double xTrackerLocal = xTracker; // you may need to us a different type here
final double yTrackerLocal = yTracker;
final double wTrackerLocal = wTracker;
final double hTrackerLocal = hTracker;
timeline2.getKeyFrames().add(
        new KeyFrame(Duration.millis(durationTracker),
        (evt -> swordAnimation(xTrackerLocal, yTrackerLocal, wTrackerLocal, hTrackerLocal)))
        );
durationTracker += durationPerFrame;
xTracker += xChangePerFrame;
yTracker += yChangePerFrame;
wTracker += wChangePerFrame;
hTracker += hChangePerFrame;