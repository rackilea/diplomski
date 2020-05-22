Set<Entry<Integer, Point3d>> entrySet = positiveCoOrdinates.entrySet();

    for (Iterator<Entry<Integer, Point3d>> iterator = entrySet.iterator(); iterator.hasNext();) {
        Entry<Integer, Point3d> entry = iterator.next();
        Point3d coOrdinate = entry.getValue();
        if (coOrdinate.x > xMaxValue || coOrdinate.y > yMaxValue
                || coOrdinate.z > zMaxValue) {
            Integer pointIndex = entry.getKey();
            negativecoOrdinates.put(pointIndex, coOrdinate);
            iterator.remove();
        }
    }