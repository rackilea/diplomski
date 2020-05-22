for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
            for (int L = 0; L < n; L++) {
                if (L != i && L != j && L != k) {
                    if (pointIsInsideTriangle(
                            points.get(i),
                            points.get(j),
                            points.get(k),
                            points.get(L))) {
                        InsidePoints.add(points.get(L));
                    }
                }
            }
        }
    }
}