// custom transferHandler which decides about imports based on source
    TransferHandler handler = new TransferHandler("icon") {

        @Override
        public boolean canImport(TransferSupport support) {
            return super.canImport(support) 
                    && support.getComponent().getParent() != imageSelectPanel;
        }

    };
    // use the handler on all labels (handlers can be shared, btw)
    // for each label on imageSelectPanel
    imageSelectLabel.setTransferHandler(handler)
    // for each label on the target panel (aka storyPanel) 
    storyLabel.setTransferHandler(handler)