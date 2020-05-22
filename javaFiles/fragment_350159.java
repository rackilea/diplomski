CTabFolder folder = new CTabFolder(parent, SWT.NONE);
 Label label = new Label(folder, SWT.NONE);
 label.setText("Hello");
 CTabItem item = new CTabItem(folder);
 item.setControl(label);
 // Hide it
 item.dipose();
 // show it again
 CTabItem item = new CTabItem(folder);
 item.setControl(label);