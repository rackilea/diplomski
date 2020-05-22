class EmployeeEntry {
    String date;
    String name;
    String surname;
    // other fields representing excel columns

    TYPE_OF_DAY typeOfday;

    public static enum TYPE_OF_DAY {
        LOP, HALF_DAY, OTHER
    }

    public String getEmployeeID() {
        // you may return name+surname or some unique ID
        return name + " " + surname;
    }

    public Integer getMonth() {
        String monthStr = date.split("-")[1];
        return asMonthNumber(monthStr);
        // implement asMonthNumber to convert Aug --> 08
    }
}

public class A {

    private Map<String, Map<Integer, List<EmployeeEntry>>> entries;

    public void parseExcel(HSSFSheet sheet) {
        entries = new HashMap<String, Map<Integer, List<EmployeeEntry>>>();
        Iterator<Row> iter = sheet.iterator();
        // for every row
        while (iter.hasNext()) {
            Row row = iter.next();
            // parse will call getString, getNumber etc of the current row
            EmployeeEntry entry = parse(row);
            Map<Integer, List<EmployeeEntry>> userMonthlyEntriesMap = getOrCreate(entry
                    .getEmployeeID());
            List<EmployeeEntry> monthlyEntries = getOrCreate(
                    userMonthlyEntriesMap, entry.getMonth());
            monthlyEntries.add(entry);
        }
    }

    public int countLOP(String employeeID, Integer monthNum) {
        int counter=0;

        Map<Integer, List<EmployeeEntry>> map = entries.get(employeeID);
        if (map != null) {
            List<EmployeeEntry> list = map.get(monthNum);
            if (list != null) {
                for (EmployeeEntry entry : list) {
                    if (entry.typeOfday == EmployeeEntry.TYPE_OF_DAY.LOP) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    private List<EmployeeEntry> getOrCreate(
            Map<Integer, List<EmployeeEntry>> userMonthlyEntriesMap,
            Integer month) {
        List<EmployeeEntry> monthlyEntries = userMonthlyEntriesMap.get(month);
        if (monthlyEntries == null) {
            monthlyEntries = new LinkedList<EmployeeEntry>();
            userMonthlyEntriesMap.put(month, monthlyEntries);
        }
        return monthlyEntries;
    }

    public Map<Integer, List<EmployeeEntry>> getOrCreate(String emplID) {
        Map<Integer, List<EmployeeEntry>> entryList = entries.get(emplID);
        if (entryList == null) {
            entryList = new HashMap<Integer, List<EmployeeEntry>>();
            entries.put(emplID, entryList);
        }
        return entryList;
    }
}