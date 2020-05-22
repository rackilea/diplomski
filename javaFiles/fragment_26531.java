public class Config extends JavaScriptObject {
  protected Config() { }

  public native final boolean hasX() /*-{ return this.x == null; }-*/;
  public native final double getX() /*-{ return this.x || 0; }-*/;
  public native final void setX(double x) /*-{ this.x = x; }-*/;
  public native final void unsetX() /*-{ delete this.x; }-*/;

  …