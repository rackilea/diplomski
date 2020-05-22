public static void setContainerAndChildrenEnabled(Container c, boolean b)
{
    Component[] allComps = c.getComponents();
    for(Component com : allComps)
    {
        com.setEnabled(b);
        if(com instanceof Container)
            setContainerAndChildrenEnabled((Container) com, b);
    }
}