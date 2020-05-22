public class Job {
    public int time; // Should n't this be a long?
    public String jobName;
}

class MyTableModel extends AbstractTableModel {
    private String[] columnNames = {"JobName", "time"};
    int numJobs=JobManager.loadNumJob();
    private List<Job> data = getDefaultTableData();

    public List<Job> getDefaultTableData(){
        List<Job> jobs = new LinkedList<Job>();
        for(int i=0; i<numJobs; i++) {
            Job job = new Job();
            job.time = /* Some int value */ 0;
            job.jobName= /* Some string value */ "";
            jobs.add(job);
        }

        return jobs;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return jobs.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        if (col==0) {
            return data.get(row).jobName;
        } else if (col==1) {
            return data.get(row).time;
        }
        return null;
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        if (col==0) {
            data.get(row).jobName = value; // Here do the casts and necessary checks.
        } else if (col==1) {
            data.get(row).time= value; // Here do the casts and necessary checks.
        }
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }