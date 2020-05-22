public static String doLinearRegression(JsArray<JsArrayNumber> points) {

    for(int i = 0; i < points.length(); i++) {
      System.out.println(points.get(i).get(0) + " " +  points.get(i).get(1));
      // do stuff
    }
    return result;
  }

  public static native void exportDoLinearRegression() /*-{ 
        $wnd.letServerWork = $entry(@ew.server.algorithm.LinearRegression::doLinearRegression(Lcom/google/gwt/core/client/JsArray;));
  }-*/;