private void addPoints(int points) {
    pointCount +=  points;

// save points to SharedPrefs
    savePoints(pointCount);

    mText.setText("Points: " + pointCount);
}