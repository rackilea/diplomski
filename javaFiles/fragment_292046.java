import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;

Event.addNativePreviewHandler(new NativePreviewHandler() {

   @Override
   public void onPreviewNativeEvent(NativePreviewEvent event) {
      if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_DELETE) { //needs an int code
         //fire an event to your button or call your method

         event.getNativeEvent().stopPropagation(); //optional
         event.getNativeEvent().preventDefault(); //optional
      }
   }
});