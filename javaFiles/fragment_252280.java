@Override
protected void populateTabMenu(final Menu menu, final MPart part)
{
  if (!isClosable(part))
    return;

  // Just add Close menu item and handle enabling it correctly

  final MenuItem menuItemClose = new MenuItem(menu, SWT.NONE);

  menuItemClose.setText(SWTRenderersMessages.menuClose);

  menuItemClose.addListener(SWT.Selection, this::closeSelected);

  menu.removeListener(SWT.Show, _menuListener);
  menu.addListener(SWT.Show, _menuListener);
}