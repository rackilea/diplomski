table = new Table();
table.addContainerProperty("Name", String.class, null);
table.addContainerProperty("Option one", OptionGroup.class, null);
opt1 = new OptionGroup("Time");
opt1.addItem("AM");     
opt1.addItem("PM");
table.addItem(new Object[] {"Name one", opt1}, new Integer(1));