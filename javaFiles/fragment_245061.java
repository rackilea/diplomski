public static class ProductTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {"id", "Name", "Price", "Quantity"};
    protected static final Class[] COLUMN_TYPES = {Integer.class, String.class, Double.class, Integer.class};
    private List<Product> products;

    public ProductTableModel(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    protected Product getProductForRow(int row) {
        return products.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = getProductForRow(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = product.getIdProduct();
                break;
            case 1:
                value = product.getNomProduct();
                break;
            case 2:
                value = product.getPrice();
                break;
            case 3:
                value = product.getQuantity();
                break;
        }
        return value;
    }

}