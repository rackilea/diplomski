public class InspectionDownloader extends DownLoader {
    Inspections inspections = Inspections.getInstance();
    List<PendingInspection> batch = new ArrayList<PendingInspection>();

    public InspectionDownloader() {
        inspections.deleteAllPendingInspections();
    }

    protected void processLine(String[] values) {
        PendingInspection pending = new PendingInspection(
            Integer.parseInt(values[0]), values[1],
            Double.parseDouble(values[2]),
            Double.parseDouble(values[3]));
        batch.add(pending);
    }

    protected void save() {
        inspections.pendingInspectionsBatchInsert(batch);
        batch.clear();
    }
    protected String file() { 
        return "inspections.txt";
    }
}