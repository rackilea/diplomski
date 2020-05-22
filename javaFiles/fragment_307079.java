List assignedRow = new ArrayList();
    double lowest = 0;
    while (assignedRow.size() < excelMatrix.length) {

        // find intial lowest value from non assign row to compare
        for (int t = 0; t < excelMatrix.length - 1; t++) {
            if (!assignedRow.contains(t)) {
                lowest = Double.parseDouble(excelMatrix[t][0]);
                break;
            }
        }

        int row = 0, column = 0;
        for (int r = 0; r < excelMatrix.length - 1; r++) {
            if (assignedRow.contains(r)) continue;
            for (int c = 0; c < excelMatrix[r].length; c++) {
                double value = Double.parseDouble(excelMatrix[r][c]);
                if (lowest > value) {
                    lowest = value;
                    row = r;
                    column = c;
                }
            }
        }
        assignedRow.add(row);
    }