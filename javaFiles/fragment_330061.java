public ModelView implements ModelListener {

  ... stuff ...

   public void modelChanged(ModelChangeEvent event) {
     if (event.getSource() == model) {
       // this is my model!
       name = model.getName();
       age = model.getAge();
       ... and any other updates that this listener cares about ...
     }
   }