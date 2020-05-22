public class ColumnName {
    public String columnName;
    public int columnIndex;

    public ColumnName( String columnName, int columnIndex ) {
        this.columnName = columnName;
        this.columnIndex = columnIndex;
    }

    public String getColumnName() {
        return columnName;


    public String toString() {
        return columnName;
    }

    public int getColumnIndex() {
        return columnIndex;
    }
}

public JComboBox createComboBox( TableModel model ) {
    int count = model.getColumnCount();
    Object[] items = new Object[count];
    for( int i = 0 ;i < count;i++ ) {
        String columName = model.getColumnName(i);
        items[i] = new ColumnName( columName,i);
    }
    return new JComboBox(items);
}

JComboBox columnCombo = createComboBox( TabelaPessoal.getModel() );

private  void Filtro(String query){
    DefaultTableModel modelo = (DefaultTableModel) TabelaPessoal.getModel();
    TableRowSorter<DefaultTableModel> pesquisa = new 
    TableRowSorter<DefaultTableModel>(modelo);
    TabelaPessoal.setRowSorter(pesquisa); 

    ColumnName columnName = ( ColumnName  ) columnCombo.getSelectedItem();
    pesquisa.setRowFilter( RowFilter.regexFilter(query, columnName.getColumnIndex() ) );             
}