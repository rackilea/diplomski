// The cast types are just an example. You can Cast/convert the array values to any type you want

IdName extractIdName(Object[] row) {
    return new IdName((String) row[0], (String) row[1], null);
}

Another extractAnother(Object[] row) {
    return new Another((String) row[2], (String) row[3], null);
}

Format extractFormat(Object[] row) {
    return new Format((String) row[4], (boolean) row[5], (boolean) row[6]);
}