public class StringPanelProvider implements PanelProvider {

    private String s;

    public StringPanelProvider(String s) {
        this.s = s;
    }

    @Override
    public Panel createPanel(Widget widget) {
        return SomeStaticUtilityClass.initPanel(new Label(s), widget);
    }
}