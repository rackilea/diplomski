class MyWidget extends Widget {
    public static MyWidget wrap(Element element) {
        MyWidget w = new MyWidget(element);
        w.onAttach();
        RootPanel.detachOnWindowClose(w);
        return w;
    }

    //Widget has protected constructor Widget(Element)
    //but it only creates widget but onAttach is called as Widget 
    //is added to Parent Widget-Panel
    protected MyWidget(Element e) {
        super(e);
    }

    //"plain" constructor for widget-panel-workflow
    public MyWidget() {
        super(Document.get().createDivElement());
    }
}