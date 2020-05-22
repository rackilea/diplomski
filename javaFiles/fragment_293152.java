for (int i = 0; i < combo.getComponentCount(); i++) 
{
    if (combo.getComponent(i) instanceof JComponent) {
        ((JComponent) combo.getComponent(i)).setBorder(new EmptyBorder(0, 0,0,0));
    }


    if (combo.getComponent(i) instanceof AbstractButton) {
        ((AbstractButton) combo.getComponent(i)).setBorderPainted(false);
    }
}