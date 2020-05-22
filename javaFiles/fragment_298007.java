XStyleFamiliesSupplier xSupplier = (XStyleFamiliesSupplier)
    UnoRuntime.queryInterface(
    XStyleFamiliesSupplier.class, xTextDocument);
 XNameAccess xFamilies = (XNameAccess) UnoRuntime.queryInterface ( 
    XNameAccess.class, xSupplier.getStyleFamilies());
 XNameContainer xFamily = (XNameContainer) UnoRuntime.queryInterface( 
    XNameContainer.class, xFamilies.getByName("PageStyles"));
// The style name may be "Default Style" or just "Default" -- check your document.  
XStyle xStyle = (XStyle) UnoRuntime.queryInterface(
    XStyle.class, xFamily.getByName("Default Style"));
XPropertySet xStyleProps = (XPropertySet) UnoRuntime.queryInterface(
    XPropertySet.class, xStyle);
xStyleProps.setPropertyValue ("HeaderIsOn", Boolean.FALSE);
xStyleProps.setPropertyValue ("FooterIsOn", Boolean.FALSE);