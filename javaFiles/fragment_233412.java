public class WidgetHelper {
    public static void sincEvent(Element element, String typeName){
        element.setAttribute("__gwtCellBasedWidgetImplDispatching" + typeName, "true");
        sinkEvent0(element, typeName);
    }

    private static native void sinkEvent0(Element element, String typeName) /*-{
        element.addEventListener(typeName,
                        @com.google.gwt.user.cellview.client.CellBasedWidgetImplStandard::dispatchNonBubblingEvent, true);
    }-*/;
}