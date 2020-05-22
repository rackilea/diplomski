public class GUIClass {
     public class MenutItemEventHandler {
           ...
     }

     public MenuItemEventHandler createEventHandler() {
           return new MenuItemEventHandler();
     }
}

...

 GUIClass guiClass = new GUIClass();
 MenuItemEventHandler handler = guiClass.createEventHandler();