public class HTMLWidgetFactory implements AbstractWidgetFactory<String> { // the interface might be overkill

    /* Oh! This class is clearly used to create HTML controls! */

    public String createButton(...) {
        return "<input type='button' />";
    }

    public String createImage(...) {
        return "<img src='lena.png' />";
    }

}