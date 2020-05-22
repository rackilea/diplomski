public interface Visitable {
    void accept(Visitor visitor);
}

public interface Visitor {
    void stringVisited(String s);
    void constructedClassVisited(ConstructedClass cs);
}

public class StringVisitable {
    private String s;

    public StringVisitable(String s) {
        this.s = s;
    }

    void accept(Visitor visitor) {
        visitor.stringVisited(s);
    }
}

// similar for ConstructedClassVisitable

public MyWidgets(Visitable visitable, final Widget widget) {
   this.widget = widget;
   visitable.accept(new Visitor() {
       public void stringVisited(String s) {
           panel = SomeStaticUtilityClass.initPanel(new Label(label), widget);
       }

       public void constructedClassVisited(ConstructedClass cs) {
           panel = SomeStaticUtilityClass.initPanelFromObject(cs, widget);
       }
   });
}