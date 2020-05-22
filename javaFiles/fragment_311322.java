ButtonModel fooModel = fooBtnGroup.getSelection();
String fooSelection = fooModel == null ? "No foo selected" : fooModel.getActionCommand();

ButtonModel barModel = barBtnGroup.getSelection();
String barSelection = barModel == null ? "No bar selected" : barModel.getActionCommand();

System.out.println("Foo selected: " + fooSelection);
System.out.println("Bar selected: " + barSelection);