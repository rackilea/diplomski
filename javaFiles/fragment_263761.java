for (int x = 0; x < screenWidth; ++x)
    for (int y = 0; y < screenHeight; ++y) {
        int r = calculateNextR(),
            g = calculateNextG(),
            b = calculateNextB();
        setPixel(r, g, b, x, y);
    }