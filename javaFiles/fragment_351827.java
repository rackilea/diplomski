/** Hides the virtual keyboard, if there is one showing. */
   public static void hideKeyboard() {
      VirtualKeyboard kb = UiApplication.getUiApplication().getActiveScreen().getVirtualKeyboard();
      if (kb != null) {
         kb.setVisibility(VirtualKeyboard.HIDE);
      }
   }

   /** @return TRUE if the virtual keyboard is hidden, or not supported */
   public static boolean isKeyboardHidden() {
      if (VirtualKeyboard.isSupported()) {
         VirtualKeyboard kb = UiApplication.getUiApplication().getActiveScreen().getVirtualKeyboard();
         if (kb != null) {
            int visibility = kb.getVisibility();
            return ((visibility == VirtualKeyboard.HIDE)
                    || (visibility == VirtualKeyboard.HIDE_FORCE));
         }
      }
      return true;
   }