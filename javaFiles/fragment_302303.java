Table table1 = new Table(
        new Record().addElement("DOC_ID", "some value")
                    .addElement("ENTITY_ID", "some value"),
        new Record().addElement("SUB_ID", "some value")
                    .addElement("CASE_DOC_ID", "some value")
);
System.out.println(table1);