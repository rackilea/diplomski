double[] bounds = new double[8];
int k = 0;
for (int i = 0; i < points.length; i++) {
    String[] lonLat = points[i].split(" ");
    for (int j = 0; j < lonLat.length; j++) {
        bounds[k++] = Double.parseDouble(lonLat[j]);
    }
}