private static void bringupDialog(WindowState state) {
   final Shell workbenchShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

   //bring up the application to front
   workbenchShell.setVisible( true );
   workbenchShell.setMinimized( false );
   workbenchShell.redraw();

   //focus on dialog
   workbenchShell.setActive();
   workbenchShell.forceActive();
   workbenchShell.setFocus();
   workbenchShell.forceFocus();
   workbenchShell.moveAbove( null );
   workbenchShell.redraw();

   Shell shell = instance.getShell(); // desired window shell
   shell.setActive();
   shell.forceActive();
   shell.setFocus();
   shell.forceFocus();
   shell.moveAbove( null );

   shell.redraw();
}