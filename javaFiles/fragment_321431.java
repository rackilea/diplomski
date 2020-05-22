String dataTypeName = "DBOBJECT";
        String dataTypeListName = "datalist";
        StructDescriptor structDescriptor = StructDescriptor.createDescriptor(dataTypeName.toUpperCase(), connection);      
        ResultSetMetaData metaData = structDescriptor.getMetaData();
        CallableStatement cs = connection.prepareCall("{call TEST_PACKAGE.get_emp_data(?)}");
        cs.registerOutParameter(1, OracleTypes.ARRAY, dataTypeListName.toUpperCase());      
        cs.execute();
        Object[] data = (Object[]) ((Array)cs.getObject(1)).getArray();
        for(Object tmp : data) {
            Struct row = (Struct) tmp;
            int index = 1;
            for(Object attribute : row.getAttributes()) {               
                System.out.println(metaData.getColumnName(index) + " : " + attribute);                                          
                ++index ;
            }

        }
        cs.close();