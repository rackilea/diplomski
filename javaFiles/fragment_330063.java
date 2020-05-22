... in a name and age sensitive listening class ...
   public void modelChanged(ModelChangeEvent event) {
     if (event.getSource() == model) {
       name = model.getName();
       age = model.getAge();
     }
   }


  ... in a name insensitive listening class ...
   public void modelChanged(ModelChangeEvent event) {
     if (event.getSource() == model) {
       // this is my model!
       age = model.getAge();
     }
   }