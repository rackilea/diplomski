public class PositionedView extends ComponentView{
   private JEditorPane view;
   private JEditorPane parent;

    @Override
    public Component createComponent(){
       if (view == null){
         view = new JEditorPane();
       }
       String innerText = dumpInnerText(getElement());
       view.setText(innerText);
       view.setLocation(getAbsoluteX(), getAbsoluteY());
       parent.add(view);
    }

    @Override
    public void setParent(View parent) {
      if (parent != null) {

        java.awt.Container host = parent.getContainer();
        if (host != null && host instanceof JEditorPane) {
            parent = (JEditorPane) host;
        }
      }

    super.setParent(parent);
   }

    protected int getAbsoluteX() {
     //search for the attribute left or right and calculate the position over parent
    }

    protected int getAbsoluteY(){
     //search for the attribute top or bottom and calculate the position over parent
    }

    protected String dumpInnerText(Element element){
     //there are several ways to do it, I used my own reader/writer, 
     //because I've need add special tags support...
    }
}