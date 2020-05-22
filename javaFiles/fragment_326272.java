private void clearTextFields(Container container)
{
    int count = container.getComponentCount();
    for (int i = 0; i < count; i++)
    {
        Component component = container.getComponent(i);
        if (component instanceof Container) {
            clearTextFields((Container) component);
        }
        else if (component instanceof JTextComponent) {
            ((JTextComponent) component).setText("");
        }
    }
}