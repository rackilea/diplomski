public class HTMLBox extends FlowPanel{

    //this will be the text shown
    private HTML html = new HTML();

    //this will be our text box with the text hidden
    private TextBox textBox = new TextBox();

    private KeyUpHandler handler = new KeyUpHandler() {

        @Override
        public void onKeyUp(KeyUpEvent event) {
            String textToShow = decorateHtml(textBox.getText()); 
            html.setHTML(textToShow);
        }
    };

    private ClickHandler ch = new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            //makes clicking on the "html" element set focus on textBox, so that user can type
            textBox.getElement().focus();       
        }
    };

    //add any tags to the text
    //like make every third letter bold
    public String decorateHtml(String html) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < html.length(); i++) {
            if (i%3 == 0) {
                sb.append("<span style='font-weight:bold;'>" + html.charAt(i) + "</span>");
            } else {
                sb.append(html.charAt(i));
            }
        }
        return sb.toString();
    }

    @Override
    public void onAttach() {
        super.onAttach();
        //height of html set to height of textBox -4
        html.getElement().getStyle().setHeight(textBox.getElement().getOffsetHeight()-4, Unit.PX);
        html.getElement().getStyle().setLeft(2.0, Unit.PX);
        html.getElement().getStyle().setBottom(2.0, Unit.PX);
    }

    public HTMLBox() {

        addDomHandler(ch, ClickEvent.getType());
        getElement().getStyle().setPosition(Position.RELATIVE);
        html.getElement().getStyle().setPosition(Position.ABSOLUTE);
        textBox.getElement().getStyle().setColor("transparent");
        textBox.addKeyUpHandler(handler);
        textBox.getElement();
        add(textBox);
        add(html);
    }

}