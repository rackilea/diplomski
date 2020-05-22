public class MyData extends JavaScriptObject {
   protected MyData() { /* required for JSOs */ }

   public final native JsArrayInteger getIds() /*-{ return this.ids; }-*/;

   public final native JsArray<JsArrayNumber> getData() /*-{ return this.data; }-*/;
}