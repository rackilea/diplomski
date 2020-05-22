NamedValue setNameProperty(String name) throws AlfrescoRuntimeException
{
    try {
        return Utils.createNamedValue(Constants.PROP_NAME, name);
    }
    catch (Exception ex) {
        throw new AlfrescoRuntimeException(ex.getMessage());
    }
}