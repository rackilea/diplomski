public class ParentPage extends WebPage {

       public ParentPage() {

            String string = new String("Dave");
            add(new Panel("childPanel", string));
            string = new String("Brian");  
       }
}