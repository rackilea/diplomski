FlexTable table = new FlexTable();

table.setText(0, 0, "January");
table.setText(0, 1, "$100");
table.setText(1, 0, "February");
table.setText(1, 1, "$80");

com.google.gwt.user.client.Element oldElement = table.getElement();
com.google.gwt.dom.client.Element element = (com.google.gwt.dom.client.Element) oldElement;
TableElement tableElement = (TableElement) element;
TableSectionElement tHead = tableElement.createTHead();

TableRowElement row = tHead.insertRow(0);
row.insertCell(0).setInnerText("Month");
row.insertCell(1).setInnerText("Savings");

RootPanel.get().add(table);