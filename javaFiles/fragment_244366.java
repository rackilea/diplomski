@Test
    public void testXML() {

        XmlSaxTableDef employeeTableDef = new XmlSaxTableDef(
                "/root/organization/employees/employee", new String[] {
                        "/root/organization/employees/employee/name",
                        "/root/organization/employees/employee/gender",
                        "index(/root/organization)"});

        XmlSaxTableDef organizationTableDef = new XmlSaxTableDef(
                "/root/organization", new String[] { 
                        "/root/organization/name",
                        "/root/organization@type" });

        DataContext dc = new XmlSaxDataContext(xmlFile, employeeTableDef,
                organizationTableDef);

        Table employeeTable = dc.getTableByQualifiedLabel("/employee");
        Column fk = employeeTable.getColumnByName("index(/root/organization)");
        Column empName = employeeTable.getColumnByName("/name");

        Table organizationTable = dc.getTableByQualifiedLabel("/organization");
        Column orgId = organizationTable.getColumnByName("row_id");
        Column orgName = organizationTable.getColumnByName("/name");
        Query q = dc.query().from(employeeTable)
                .innerJoin(organizationTable).on( fk, orgId )
                .select(empName).as("employeename")
                .select(orgName).as("companyname").toQuery();
        DataSet ds = dc.executeQuery(q);

        List<Row> rows = ds.toRows();
        for (Row r : rows) {
            System.out.println(Arrays.deepToString(r.getValues()));
        }

    }