public class TimeClockManager {

    private Map<Integer, List<TimeClockEntry>> timeClockEntries;

    public TimeClockManager() throws IOException, ParseException {
        timeClockEntries = new HashMap<>(25);
        try (BufferedReader br = new BufferedReader(new FileReader(new File("TimeClock1.txt")))) {
            String text = null;
            TimeClockEntry entry = null;
            int line = 0;
            while ((text = br.readLine()) != null) {

                if (line % 2 == 0) {
                    entry = new TimeClockEntry(text);
                } else {
                    entry.setClockTimeFrom(text);

                    List<TimeClockEntry> empEntries = timeClockEntries.get(entry.getEmployeeID());
                    if (empEntries == null) {
                        empEntries = new ArrayList<>(25);
                        timeClockEntries.put(entry.getEmployeeID(), empEntries);
                    }

                    empEntries.add(entry);

                }
                line++;

            }
        }
    }

    public List<TimeClockEntry> getByEmployee(Employee emp) {

        List<TimeClockEntry> list = timeClockEntries.get(emp.getId());
        list = list == null ? new ArrayList<>() : list;
        return Collections.unmodifiableList(list);

    }

}