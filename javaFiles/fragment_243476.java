final int[] counter = {0};
Collections.sort(drivDataList, new Comparator<DrivData>() {
    @Override
    public int compare(DrivData o1, DrivData o2) {
        long l1 = o1.getTime();
        long l2 = o1.getTime();
        if (l1 > l2) {
            return 1;
        } else if (l1 < l2) {
            return -1;
        } else {
            counter[0]++;
            return 0;
        }
    }
});
//use counter