@Override
  protected Control createContents(final Composite parent)
  {
    final Control control = super.createContents(parent);

    parent.getDisplay().asyncExec(new Runnable() {
      public void run()
      {
        MessageDialog.openInformation(getShell(), "title", "message");
      }
    });

    return control;
  }