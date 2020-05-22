Object mmservice = null;
try {
    // Create an instance of the MailMerge service
    mmservice = mxMCF.createInstanceWithContext(
        "com.sun.star.text.MailMerge", mxComponentContext);
}
// Get the XPropertySet interface of the mmservice object
XPropertySet oObjProps = (XPropertySet)
    UnoRuntime.queryInterface(XPropertySet.class, mmservice);
try {
    // Set up the properties for the MailMerge command
    oObjProps.setPropertyValue("DataSourceName", mDataSourceName);
}
// Get XJob interface from MailMerge service and call execute on it
XJob job = (XJob) UnoRuntime.queryInterface(XJob.class, mmservice);
try {
    job.execute(new NamedValue[0]);
}