public class ExtendedHTMLEditorKit extends HTMLEditorKit{
//.... other code here
    public class MyHTMLFactory extends HTMLFactory{
      //other code here
      @Override
      public View create(Element elem) {
          if (isLayered(elem)){ //it means, it has position attribute
             return new PositionedView(elem);
          }
          else 
            return super.create(elem);
      }

      boolean isLayered(Element elem){
          SimpleAttributeSet sas = new  SimpleAttributeSet(elem);
          StyleSheet styles = (HTMLDocument elem.getDocument).getStyleSheet();
          Tag tag = element.getAttributes().getAttribute(AttributeSet.NameAttribute);
          sas.addAttributes(styleSheet.getRule(tag, element));
          return sas.isDefined("position") 
            && !sas.getAttribute("position").toString().equalsIgnorecase("static");
      }
    }
}