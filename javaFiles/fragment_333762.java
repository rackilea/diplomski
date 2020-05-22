@Override
public int compare(SingleMeasurementValuePoint point1,
        SingleMeasurementValuePoint point2) {
    if (point1 == null && point2 == null) {
        System.out.println("null point1 and point2");
        return 0;
    } else if (point1 == null) {
        System.out.println("null point1");
        return -1;
    } else if (point2 == null) {
        System.out.println("null point2");
        return 1;
    }
    int val = point1.compareTo(point2);
    if (val == 0) {
        return point1.getComponentId().compareTo(
                point2.getComponentId());
    } else {
        return val;
    }
}