private native void registerUploadListener(MessageEntry instance) /*-{
    $wnd.Namespace.on($wnd.Namespace.Events.UPLOAD, function() {
        instance.@mypath.widget.MessageEntry::switchToDocumentUpload()();
    });
}-*/;

private void initLayout() {
    initWidget(mainDockLayoutPanel);

    Conversation model = conversationController.getModel();
    messageEntryPanel.getElement().addClassName("richTextAreaId" + model.getId());
    BackboneController.loadMessageEntry(".richTextAreaId" + model.getId(), "message", model.getId(), QuipuId.NULL, (Boolean)PreferencesModel.getInstance().isAutoSubmit());
    registerUploadListener(this);
    mainDockLayoutPanel.addStyleName(MessageEntryBundle.instance.css().container());

    modeSimplePanel.add(messageEntryPanel);
    mainDockLayoutPanel.add(modeSimplePanel);
}