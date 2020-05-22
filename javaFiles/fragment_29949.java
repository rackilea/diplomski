ExtElement extElement = Ext.get("myWindow");
if (extElement != null && Ext.getCmp(extElement) != null
    && Ext.getCmp(extElement) instanceof Window) {
    Window window = (Window) Ext.getCmp(extElement);
    window.close();
}