final Tree tree = viewer.getTree();

final Menu menu = new Menu(tree);
tree.setMenu(menu);
menu.addMenuListener(new MenuAdapter()
{
    @Override
    public void menuShown(MenuEvent e)
    {
        Point point = tree.toControl(Display.getDefault().getCursorLocation());
        boolean found = false;
        for (TreeItem item : tree.getItems())
        {
            for (int i = 0; i < tree.getColumnCount(); i++)
                if (item.getBounds(i).contains(point))
                    found = true;
        }

        System.out.println(found);
    }
});