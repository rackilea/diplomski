Table table = new Table(new Shell(new Display()), SWT.NONE);
table.setHeaderVisible (true);
TableColumn column = new TableColumn (table, SWT.NONE);
StyledText styledText = new StyledText(table, SWT.NONE);
TableItem item = new TableItem (table, SWT.NONE);
TableEditor editor = new TableEditor (table);
editor.grabHorizontal = true;
editor.grabVertical = true;
editor.setEditor (styledText, item, 0);