engine.setConfirmHandler(()->{
   // in JavaFX context

   SwingUtilities.invokeLater(()->{
      // in Swing context
      boolean result = showModalDialog();
      Platform.runLater(()->{
          // back to JavaFX context
          Toolkit.getToolkit().exitNestedEventLoop(key, result)
      })
   });

   // Wait for result
   boolean result = Toolkit.getToolkit().enterNestedEventLoop(this)
   // still in JavaFX context
   return result;
});