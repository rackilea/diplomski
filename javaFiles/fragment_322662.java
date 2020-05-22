private List<Double[]> bestPoints(List<Double[]> includedPoints) {
    List<Double[]> bestPoints = new ArrayList<Double[]>();
    for (Double[] tempPoint : tempPoints) {
        if (tempPoint[2] == maxCount) {
             bestPoints.add(new Double[] { tempPoint[0], tempPoint[1] });
        }
    }

    return bestPoints;
}