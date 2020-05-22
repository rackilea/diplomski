// table model to hold and display our course data
@SuppressWarnings("serial")
class MyTableModel extends DefaultTableModel {
    // Table's column header Strings
    public static final String[] COL_NAMES = {"Course Name", "Course Grade"};

    public MyTableModel(int rowCount) {
        super(COL_NAMES, rowCount);
    }

    @Override
    public int getColumnCount() {
        return COL_NAMES.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Double.class;
        }
        return super.getColumnClass(columnIndex);
    }

    public void addRow(Course course) {
        Object[] rowData = {course.getName(), course.getGrade()};
        super.addRow(rowData);
    }

    public Course getRow(int rowIndex) {
        //get data, handling nulls carefully
        String name = (String) getValueAt(rowIndex, 0);
        name = name == null? "" : name;
        Object colObject = getValueAt(rowIndex, 1);
        double grade = colObject == null ? 0.0 : (double) colObject;
        return new Course(name, grade);
    }


    public double getAverageGrade() {
        // if no rows, either return 0.0 
        if (getRowCount() == 0) {
            return 0.0;  // ? or throw an exception ?
        }

        // summation variable
        double total = 0.0;
        for (int i = 0; i < getRowCount(); i++) {
            // iterate through the table extracting grades and adding to total
            total += getRow(i).getGrade();
        }

        // calculate and return the average
        return total / getRowCount();
    }
}