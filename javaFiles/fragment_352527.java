// Declare list as "final" (or make it a field of the enclosing class)
final JList list = ...;
list.getSelectionModel().addListSelectionListener(new ListSelectionListener()
{
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        // Can access the list here:
        Object object = list.getSelectedValue();
        ...
    }
});