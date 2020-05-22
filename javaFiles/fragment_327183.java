if (speed < 10 ) {
    if (pointAvaialable <= 0) {
        JOptionPane.showMessageDialog(null, "You are out of available points");
        return;
    }

    speed = speed + 1 ;
    pointsAvailable = pointsAvailable - 1 ;
    availablePoints.setText(String.valueOf(pointsAvailable));
    speedPoints.setText(String.valueOf(speed));
} else {
     JOptionPane.showMessageDialog (null, "You have maxed out your Speed");
}