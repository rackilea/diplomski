GeneralPath topBox = new GeneralPath();
topBox.moveTo(0, 0);
// upper right
topBox.lineTo(width, 0);
// lower right; move diagonally down and to the left as in a picture frame
topBox.lineTo(width - (insetX / 2), 0 + (insetY / 2));
// lower left
topBox.lineTo((insetX / 2), 0 + (insetY / 2));
topBox.closePath();
g2.fill(topBox);