public class OefeningenTableModel extends AbstractTableModel {

    ArrayList<Oefening> oefeningen;

    public OefeningenTableModel(){
        oefeningen = DAOFactory.getFactory(0).getIDAOOefening().load();
    }    

    @Override
    public int getRowCount() {
        return oefeningen.getSize();
    }

    @Override
    public int getColumnCount() {
        // You'll need to fill this out to meet your requirements
    }

    @Override
    public String getColumnName(ing column) {
        // You'll need to fill this out to meet your requirements
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // You'll need to fill this out to meet your requirements
    }

}