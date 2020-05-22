private List<PreSale> findTotalPSHrs(List<PreSale> data) {
    HashMap<String, Integer> cumulative = new HashMap<String, Integer>();

    for (PreSale item : data) {
        String key = item.getWeek() + "," + item.getProjectID().toString();
        if (cumulative.containsKey(key)) {
            cumulative.put(key, cumulative.get(key) + data.getHours());
        } else {
            cumulative.put(key, data.getHours());
        }
    }

    // at this point, cumulative contains a single entry for each project/week with
    // the cumulative hours.  Now we need to convert that into your output list.

    List<PreSale> returnList = new ArrayList<PreSale>();
    for (Map.Entry<String, Integer> entry : cumulative.entrySet()) {
        // "<week>,<project>"
        String[] parts = entry.getKey().split(",");
        PreSale saleObj = new PreSale();
        saleObj.setWeek(parts[0]);
        saleObj.setProject(Integer.parseInt(parts[1]));
        saleObj.setHours(entry.getValue());
        returnList.add(saleObj);
    }

    return returnList;
}