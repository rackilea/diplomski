public class MyClass implements IsWidget {
    private final HTML text;

    public MyClass() {
        text = new HTML(SafeHtmlUtils.fromTrustedString("<b>Some text</b>"));
        text.addDomHandler(new ContextMenuHandler() {
            @Override
            public void onContextMenu(ContextMenuEvent event) {
                String test = getSelection();
                Window.alert(test);
            }
        }, ContextMenuEvent.getType());
    }

    private native String getSelection() /*-{
        var text = "";
        if ($wnd.getSelection) {
            text = $wnd.getSelection().toString();
        } else if ($doc.selection && $doc.selection.type != "Control") {
            text = $doc.selection.createRange().text;
        }
        return text;
    }-*/;

    @Override
    public Widget asWidget() {
        return text;
    }
}