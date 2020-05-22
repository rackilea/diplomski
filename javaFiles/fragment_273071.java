public class ParentPage extends WebPage {

       public ParentPage() {

            String string = new String("Dave");
            IModel model = new Model(string);

            add(new Panel("childPanel", model));
            model.setObject(new String("Brian"));  
       }
}