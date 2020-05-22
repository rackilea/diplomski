private void keyPressed(KeyEvent event) {
  for (MenuItem mi : tabPane.getContextMenu().getItems())
     {
        if (mi.getAccelerator()!=null && mi.getAccelerator().match(event))
        {
            mi.getOnAction().handle(null);
            event.consume();
            return;
        }
    }
}