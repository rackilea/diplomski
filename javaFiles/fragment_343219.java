double[] Cover = new double[frames.size() * nParam];

for (int i = 0; i < frames.size(); i++) {
    double[] finMc = Gos.getVek(frames.get(i));
    for (int c = 0; c < finMc.length; c++) {
        Cover[i * frames.size() + c] = finMc[c];
    }
}