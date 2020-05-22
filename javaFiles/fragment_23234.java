public class ModelDAO extends AbstractTableModel {

    private List<?> data; 

    public ModelDAO(List data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return this.data.size(); 
    }

    @Override
    public int getColumnCount() {
        return data.get(0).getClass().getDeclaredFields().length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            Method[] methods = data.get(rowIndex).getClass().getDeclaredMethods(); 
            Arrays.sort(methods, new ComparatorReflection<Method>()); 
            return methods[2*columnIndex].invoke(data.get(rowIndex), null);
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Field[] fields = data.get(0).getClass().getDeclaredFields(); 
        Arrays.sort(fields, new ComparatorReflection<Field>()); 
        return fields[columnIndex].getType(); 
    }

    @Override
    public String getColumnName(int column) {
        Field[] fields = data.get(0).getClass().getDeclaredFields(); 
        Arrays.sort(fields, new ComparatorReflection<Field>()); 
        return fields[column].getAnnotation(ColumnName.class).value(); 
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Field[] fields = data.get(rowIndex).getClass().getDeclaredFields(); 
        Arrays.sort(fields, new ComparatorReflection<Field>()); 
        return fields[columnIndex].getAnnotation(Updatable.class).value(); 
    }
}