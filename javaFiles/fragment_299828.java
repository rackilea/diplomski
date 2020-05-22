for (int i = 0; i < w; i++) {
    for (int j = 0; j < h; j++) {
        // calculate Euclidean distance to source
        double dx = i - x, dy = j - y;
        double dist = Math.sqrt(dx * dx + dy * dy);

        // no need to check bounds explicitly here
        wave[i][j] = Math.sin(f * dist + phase);
    }
}