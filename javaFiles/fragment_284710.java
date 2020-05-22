public boolean isReallySameId(GuiTestObject obj1, GuiTestObject obj2)
{
    Object id1 = obj1.getProperty(".associatedId");
    Object id2 = obj2.getProperty(".associatedId");
    // I don't know if this property always exists
    if ((id1 == null) || (id2 == null)) return false;
    return (id1.equals(id2));
}

public boolean isReallyInScreen(GuiTestObject obj)
{
    Rectangle screen = RootTestObject.getRootTestObject().getScreen().getScreenRectangle();
    Rectangle intersection = screen.intersection(obj.getScreenRectangle());
    return ((intersection.width > 0) && (intersection.height > 0));
}

public boolean isReallyVisible(GuiTestObject obj)
{
    if (!isReallyInScreen(obj)) return false; // basic check
    GuiTestObject parent = (GuiTestObject) obj.getMappableParent();
    if (parent == null) return true; // top object in screen
    GuiTestObject found;
    while (parent != null)
    {
        found = (GuiTestObject) parent.getChildAtPoint(obj.getScreenPoint());
        if ((found == null) || (!isReallySameId(found, obj))) return false;
        obj = parent;
        parent = (GuiTestObject) obj.getMappableParent();
    }
    return true;
}