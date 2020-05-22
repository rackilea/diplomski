public class FileIOTableModel extends AbstractTableModel {

    public static final String[] COLUMN_NAMES = {
        "Course",
        "Name",
        "Moderator",
        "Semester",
        "Program",
        "Major",};

    private FileIOManagement manager;

    public FileIOTableModel(FileIOManagement manager) {
        this.manager = manager;
    }

    @Override
    public int getRowCount() {
        int row = manager.getCourseList().size();
        row = Math.max(row, manager.getMajorList().size());
        row = Math.max(row, manager.getModeratorList().size());
        row = Math.max(row, manager.getNameList().size());
        row = Math.max(row, manager.getProgramList().size());
        row = Math.max(row, manager.getSemesterList().size());
        return row;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        List<String> data = null;
        switch (columnIndex) {
            case 0:
                data = manager.getCourseList();
                break;
            case 1:
                data = manager.getNameList();
                break;
            case 2:
                data = manager.getModeratorList();
                break;
            case 3:
                data = manager.getSemesterList();
                break;
            case 4:
                data = manager.getProgramList();
                break;
            case 5:
                data = manager.getMajorList();
                break;
        }

        Object value = null;
        if (data != null) {
            if (rowIndex < data.size()) {
                value = data.get(rowIndex);
            }
        }

        return value;

    }

}