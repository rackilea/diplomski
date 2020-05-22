public CustomCellEditor(int maxStringLength)
    {
        super(new JTextField());
        ((JTextField) editorComponent).setDocument(new CustomDocument(maxStringLength));
        ((JTextField) editorComponent).setBorder(null); // cast may be not needed
    }