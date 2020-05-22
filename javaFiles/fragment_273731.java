final DynamicForm df = new DynamicForm();
    // FormItem[] fi = new FormItem[3];
    // filling the list with one CheckboxItem, one TextItem and one SelectItem

    CheckboxItem ci = new CheckboxItem();
    ci.setShowTitle(false);
    ci.setTitle("");

    TextItem ti = new TextItem();
    ti.setShowTitle(false);

    SelectItem si = new SelectItem();
    si.setShowTitle(false);
    si.setValues("PDF");

    df.setItems(ci, ti, si);

    df.setColWidths("20", "250", "*");
    df.setNumCols(3);
    // df.setFields(fi);

    RootPanel.get().add(df);