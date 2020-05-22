private void tipsOff(Container container)
{
  Component [] c = container.getComponents();
  Component s;
  for (Component cc : c) {
    ((JComponent)cc).setToolTipText("");
    if(cc instanceof JPanel)      tipsOff((Container) cc);
    if(cc instanceof JScrollPane) tipsOff(((JScrollPane)cc).getViewport());
  }
}  

private void mniPrefTooltipsActionPerformed(java.awt.event.ActionEvent evt)
{                                                
  tipsOff(gui.getContentPane());
  tipsOff(gui.mbrMenuBar);
}