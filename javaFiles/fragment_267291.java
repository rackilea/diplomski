public static int getHighestMarkByType(ArrayList<eProperty> allData, String type) {

    Predicate predicate = new Predicate() {
        public boolean evaluate(Object data) {
            if ((eProperty) data).getType().equals(type)) {
                return true;
            } else {
                return false;
            }
        }
    };

    ArrayList<eProperty> filteredData = (ArrayList<eProperty>) CollectionUtils.select(allData,predicate);

    int maxMarks = 0;

    for (eProperty data : filteredData) {
        if (data.getMarks() > maxMark) {
            maxMarks = data.getMark();
        }
    }

    return maxMarks;
}