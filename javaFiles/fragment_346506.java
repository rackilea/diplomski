myTabbedPane.setUI(new BasicTabbedPaneUI() {
   @Override
   protected void installDefaults() {
       super.installDefaults();
       highlight = Color.pink;
       lightHighlight = Color.green;
       shadow = Color.red;
       darkShadow = Color.cyan;
       focus = Color.yellow;
   }
});