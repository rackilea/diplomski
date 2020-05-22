protected void installDefaults() {
    LookAndFeel.installColorsAndFont(tabPane, "TabbedPane.background",
                                "TabbedPane.foreground", "TabbedPane.font");     
    highlight = UIManager.getColor("TabbedPane.light");
    lightHighlight = UIManager.getColor("TabbedPane.highlight");
    shadow = UIManager.getColor("TabbedPane.shadow");
    darkShadow = UIManager.getColor("TabbedPane.darkShadow");
    //...
    // a lot more stuff
    //...
}