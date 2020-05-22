XSingleServiceFactory service = UnoRuntime.queryInterface(XSingleServiceFactory.class,
                msf.createInstance("com.sun.star.sdb.DatabaseContext"));
Object datasourceObject = service.createInstance();
XDocumentDataSource datasourceDocument =
                UnoRuntime.queryInterface(XDocumentDataSource.class, datasourceObject);
XPropertySet datasourceProperties =
                UnoRuntime.queryInterface(XPropertySet.class, datasourceObject);
XPropertySet datasourceSettings =
                UnoRuntime.queryInterface(XPropertySet.class,
                datasourceProperties.getPropertyValue("Settings"));
datasourceSettings.setPropertyValue("Extension", "csv");
datasourceSettings.setPropertyValue("FieldDelimiter", ";");