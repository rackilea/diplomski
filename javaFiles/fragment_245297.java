public class Editor implements ShapeVisitor{
    @Override
    public Foo visit(CircleObject circle, Object context) {
          return new Foo(circle, (String) context));
    }

    @Override
    public void visit(RectangleObject rectangle) {

    }


    public void setComponent(JsonArray arguments){
      Element element = getFromJson(arguments);
      Foo foo = (Foo)element.getAttrs().visit(this, "Hello");
    }
}