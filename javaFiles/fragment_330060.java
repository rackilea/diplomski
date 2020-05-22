public class ModelChangeEvent {

   private Model source;

   public ModelChangeEvent(Model source, <possibly other fields here>) {
     this.source = source;
   }

   public Model getSource() {
     return source;
   }
 }