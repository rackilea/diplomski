public class BarChartOptions extends Options {
    protected BarChartOptions() {
    }

    public final native void setGroupWidth(String groupWidth) /*-{
        this.bar = { groupWidth: groupWidth }
    }-*/;

    public static BarChartOptions create() {
        return JavaScriptObject.createObject().cast();
    }
}