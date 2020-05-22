public class SimpleColorTableModel extends DefaultTableModel {

    public SimpleColorTableModel() {

        addColumn("Name");
        addColumn("Color");

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        Class clazz = String.class;

        switch (columnIndex) {

            case 1:
                clazz = Color.class;
                break;

        }

        return clazz;

    }

}