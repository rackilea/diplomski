final DynamicForm df = new DynamicForm();
    // FormItem[] fi = new FormItem[3];

    CheckboxItem ci = new CheckboxItem();
    ci.setShowTitle(false);
    ci.setTitle("");

    SelectItem si = new SelectItem();
    si.setTitle("LANGUAGE");
    si.setValues("PDF");

    df.setItems(ci, si);

    df.setColWidths("20", "250", "*");
    df.setNumCols(3);
    // df.setFields(fi);

    RootPanel.get().add(df);