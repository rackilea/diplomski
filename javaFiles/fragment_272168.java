public interface JQuery extends JsniBundle {
   @LibrarySource("http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js")
   // You can use javascript files placed in your source tree as well
   // @LibrarySource("jquery.js")
   public void load();
}

// Generate the Bundle implementation
JQuery jQuery = GWT.create(JQuery.class);
// Load the third-party library
jQuery.load();