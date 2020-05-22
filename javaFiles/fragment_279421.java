@Override
protected void setControl(Control newControl) {
  super.setControl(newControl);

  PlatformUI.getWorkbench().getHelpSystem().setHelp(newControl, "your help context id");
}