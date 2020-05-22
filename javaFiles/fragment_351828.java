import net.rim.device.api.ui.TouchEvent;

   protected boolean touchEvent(TouchEvent event) {
      // We take action when the user completes a click (a.k.a. unclick)
      int eventCode = event.getEvent();
      if ((eventCode == TouchEvent.UNCLICK) || (eventCode == TouchEvent.DOWN)) {
         // Get the touch location, within this Manager
         int x = event.getX(1);
         int y = event.getY(1);

         if ((x >= 0) && (y >= 0) && (x < getWidth()) && (y < getHeight())) {
            int field = getFieldAtLocation(x, y);
            if (field >= 0) {
               // Let event propagate to child field
               return super.touchEvent(event);
            } else {
               if (eventCode == TouchEvent.UNCLICK) {
                  // A completed click anywhere else in this manager should dismiss the keyboard
                  UiUtilities.hideKeyboard();
               } else {
                  // This is just a soft touch (TouchEvent.DOWN), without full click
                  setFocus();
               }
               // Consume the event
               return true;
            }
         }
      }
      // Event wasn't for us, let superclass handle in default manner
      return super.touchEvent(event);
   }