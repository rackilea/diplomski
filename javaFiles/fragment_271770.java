Collections.sort(onlyGuardsStatArray, new Comparator<DatabaseGuard>() {

        public int compare(DatabaseGuard p1, DatabaseGuard p2) {
            int endShiftInt = (int) p1.getEndShift() / 1000;
            int endShiftInt2 = (int) p2.getEndShift() / 1000;

            if (endShiftInt == endShiftInt2) {
                return Integer.valueOf(p1.getPoints()).compareTo(p2.getPoints());
            }
            return Integer.valueOf(endShiftInt).compareTo(endShiftInt2);
        }
    }
    );