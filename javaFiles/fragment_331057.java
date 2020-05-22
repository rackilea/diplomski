class A{
   ...
   //action
   String v = textField.getText();
   B b = new B(v);
   ...
}

class B{
   public B(String v){
      this.label.setText(v);
   }
}