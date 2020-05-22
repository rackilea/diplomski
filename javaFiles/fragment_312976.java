for (int i=0; i < horizontal.size(); ++i) {
    for (int j=i+1; j < horizontal.size(); ++j) {
        List<Line2D> line1 = horizontal.get(i);
        List<Line2D> line2 = horizontal.get(j);

        for (int k=0; k < line1.size(); ++k) {
            for (int l=0; l < line2.size(); ++l) {
                if (Math.abs(line1.get(k).getY1() - line2.get(l).getY1()) < 0.4) {
                    // do something
                }
            }
        }
    }
}