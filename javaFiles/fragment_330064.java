... in a name and age sensitive listening class ...
  ... note that _name_ is the name in the _view_ not the model! ...
   public void modelChanged(ModelChangeEvent event) {
     if (event.getSource() == model) {
       name = capitalize(model.getName());
       age = model.getAge();
     }
   }