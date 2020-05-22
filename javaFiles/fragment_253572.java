ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
listViewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

listViewer.setContentProvider(ArrayContentProvider.getInstance());

ArrayList<String> contents = new ArrayList<>();
contents.add("a");
contents.add("b");
contents.add("c");

listViewer.setInput(contents);

Button btnRemoveFile = new Button(shell, SWT.PUSH);
btnRemoveFile.setText("Remove");
btnRemoveFile.addSelectionListener(new SelectionAdapter() {
  @Override
  public void widgetSelected(final SelectionEvent e) {
      IStructuredSelection selectionFile = listViewer.getStructuredSelection();
      final Object removeFile = selectionFile.getFirstElement();
      // TODO check for no selection

      listViewer.remove(removeFile);

      contents.remove(removeFile);
  }
});