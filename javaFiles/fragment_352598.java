/**
 * Just an example: can export Person objects from a list an
 * import to a table with two columns
 */
public static class PersonTransferHandler extends TransferHandler {

    DataFlavor personFlavor = new DataFlavor(PersonObject.class, "PersonObject");
    DataFlavor[] flavors = new DataFlavor[] {personFlavor};

    /**
     * Implemented to return true if the support can provide string values.
     */
    @Override
    public boolean canImport(TransferSupport support) {
        if (!support.isDrop()) {
            return false;
        }
        if (!(support.getComponent() instanceof JTable)) {
            return false;
        }
        return isSupportedType(support);
    }


    @Override
    public boolean importData(TransferSupport support) {
        if (!canImport(support)) {
            return false;
        }
        try {
            PersonObject person = (PersonObject) support.getTransferable().getTransferData(personFlavor);
            Object[] rowData = new Object[]{person.firstName, person.lastName};
            JTable table = (JTable) support.getComponent();
            ((DefaultTableModel) table.getModel()).addRow(rowData);
            return true;
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    protected Transferable createTransferable(JComponent c) {
        if (!(c instanceof JList)) return null;
        JList list = (JList) c;
        final PersonObject person = (PersonObject) list.getSelectedValue();
        Transferable t = new Transferable() {

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return flavors;
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return personFlavor.equals(flavor);
            }

            @Override
            public Object getTransferData(DataFlavor flavor)
                    throws UnsupportedFlavorException, IOException {
                return person;
            }

        };
        return t;
    }



    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }


    private boolean isSupportedType(TransferSupport support) {
        DataFlavor[] flavors = support.getDataFlavors();
        for (DataFlavor dataFlavor : flavors) {
            if (dataFlavor.getRepresentationClass() == PersonObject.class) return true;
        }
        return false;
    }

}

public static class PersonObject {
    String firstName;
    String lastName;

    public PersonObject() {

    }
    /**
     * @param firstName
     * @param lastName
     */
    public PersonObject(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}