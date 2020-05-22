public float[] parseSalesFile(List<String> salesFile) {
    float[] salesAsFloat = new float[salesFile.size() * 7];
    for (int w = 0; w < salesFile.size(); w++) {
        String[] salesByDay = salesFile[w].split(",");
        for (int d = 0; d < salesByDay; d++)
            salesAsFloat[w * 7 + d] = Float.parseFloat(daySales);
    }
    return salesAsFloat;
}