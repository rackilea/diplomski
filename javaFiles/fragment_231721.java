public List<Map> queryResultToListMap(String query, List queryResult) {
        int indexOffrom = query.indexOf("from");
        int indexOfselect = query.indexOf("select");
        String subquery = query.substring(indexOfselect, indexOffrom);
        subquery = subquery.replace("select", "");
        String[] arr = subquery.split(",");

        List cols = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            String[] subarr = arr[i].split(" ");
            cols.add(subarr[subarr.length - 1]);
        }
        List<Map> colswithdata = new ArrayList<>();
        Iterator itr = queryResult.iterator();

        while (itr.hasNext()) {
            HashMap colsWithData = new HashMap();
            Object[] tempArray = (Object[]) itr.next();
            for (int i = 0; i < cols.size(); i++) {
                colsWithData.put(cols.get(i), tempArray[i].toString());
            }
            colswithdata.add(colsWithData);

        }

        return colswithdata;
    }