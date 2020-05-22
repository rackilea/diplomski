public class VstTableItemModel extends AbstractTableModel {

    private List<User> users;

    public VstTableItemModel(List<User> users) {

        this.users = new ArrayList<User>(users);

    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "??";
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = user.getUserUsername();
                break;
            case 1:
                value = user.getUserName();
                break;
            case 2:
                value = user.getUserPhone();
                break;
            case 3:
                value = user.getUserNic();
                break;
            case 4:
                value = user.getUserAddress();
                break;
            case 5:
                value = user.getUserEmail();
                break;
        }

        return value;

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return // Return the class that best represents the column...
    }

    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
    */

    /**
     * This will return the user at the specified row...
     * @param row
     * @return 
     */
    public User getUserAt(int row) {
        return users.get(row);
    }

}