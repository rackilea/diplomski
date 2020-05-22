Event.addNativePreviewHandler(new NativePreviewHandler()
{
   @Override
   public void onPreviewNativeEvent(NativePreviewEvent event)
   {
      // tab is key 9
      if (event.getNativeEvent().getKeyCode() == 9)
      {
         event.cancel();
      }
   }
});