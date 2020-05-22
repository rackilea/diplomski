public class BasicLayout {
    protected HashMap<String, ScreenElement> screenElements = new HashMap<>();

    public BasicLayout() 
    {
        screenElements.put("BACKGROUND", new ScreenElement(...));
        screenElements.put("BOXONE", new ScreenElement(...));
        screenElements.put("BOXTWO", new ScreenElement(...));
    }

    public HashMap<String, ScreenElement> getScreenElements() {
        return screenElements;
    }

    public ScreenElement getScreenElement(String elementName) {
        return screenElements.get(elementName);
    }

    public void draw(Canvas canvas) {
        for (ScreenElement screenElement: screenElements) {
            screenElement.draw(canvas);
        }
    }
}

public class OtherLayout extends BasicLayout {     
    public OtherLayout() {
        screenElements.put("BOXTHREE", new ScreenElement(...));
        screenElements.put("BOXFOUR", new ScreenElement(...));
    }
}