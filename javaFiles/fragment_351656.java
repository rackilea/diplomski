int colorOffset = ... // Counted up or down all the time

// The index of the color for the i'th letter
int colorIndex = (i+colorOffset)%colors.length;
if (colorIndex < 0) colorIndex += colors.length;
g.setColor(colors[colorIndex]);