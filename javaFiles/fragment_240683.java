@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
{
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

    MyCustomObject customObject = (MyCustomObject)value;

    setText( customObject.getText() );
    setIcon( customObject.getIcon() );

    return this;
}