x = 0, y = 100,
for (dx = 0; dx < 3; ++dx) {
    for (dy = 0; dy < 3; ++dy) {
        drawTile(x + dy * width / 2, y - dy * height / 2);
    }
    x += width / 2;
    y += height / 2;
}