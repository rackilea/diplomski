public NavClickHandler(UI ui) //UI extends HLayout
{
    this.ui = ui;
}

@Override
public void onNodeClick(NodeClickEvent event) {
    Window window = new Window();

    window.setWidth100();
        window.setHeight100();
        window.setHeaderControls(HeaderControls.HEADER_LABEL);

    window.setTitle(event.getNode().getAttribute("name"));
    window.addItem(new Label("Huzzah!"));

    ui.setMainView(window);
}