public void setToolTipText(String text) {
        String oldText = getToolTipText();
        putClientProperty(TOOL_TIP_TEXT_KEY, text);
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();
        if (text != null) {
        if (oldText == null) {
                toolTipManager.registerComponent(this);
        }
        } else {
            toolTipManager.unregisterComponent(this);
        }
    }