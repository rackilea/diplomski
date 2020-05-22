private void layoutComponent(Component component)
{
    synchronized (component.getTreeLock())
    {
        component.doLayout();

        if (component instanceof Container)
        {
            for (Component child : ((Container)component).getComponents())
            {
                this.layoutComponent(child);
            }
        }
    }
}