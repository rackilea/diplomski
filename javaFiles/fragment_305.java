boolean match = true;
for (int dx = -1; match && (dx < 2); ++dx) {
    for (int dy = -1; match && (dy < 2); ++dy) {
        if (dx != 0 || dy != 0) {
            match = pan[x+dx][y+dy].getBackground() == TeamColour;
        }
    }
}
if (match) {
    // do something
}