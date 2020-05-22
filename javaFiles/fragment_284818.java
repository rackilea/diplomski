Point spot = new Point();
Component currComponent = p;
while ( currComponent != null && currComponent != mainPanel ) {

    Point relativeLocation = currComponent.getLocation();
    spot.translate( relativeLocation.x, relativeLocation.y );
    currComponent = currComponent.getParent();
}


((JLabel) p).setText(spot.toString());