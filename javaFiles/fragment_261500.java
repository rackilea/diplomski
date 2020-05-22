private void initComponents() {
   JFrame mainframe = new JFrame("Main Frame");
   Editor editor = new Editor();
   Toolbar toolbar = new Toolbar();
   toolbar.addListener(editor); // register listener
   ...
}