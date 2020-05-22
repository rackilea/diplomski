public static native MyObject nativeJSFuncGwt(MyObject obj) /*-{

   var xyz = $wnd.someJsFunc();

   obj.@package.name::setter1(Ljava/lang/String;)(xyz);

   return obj;

 }-*/;