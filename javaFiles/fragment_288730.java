My_Class3 var1;
public void initialize(My_Class my_context)  {
    super.initialize(my_Context);
    var1 = My_Class3();
  }


  public void work(My_Class2 elt) {
    String text = elt.getText();
    String new_text = var1.my_method(text);
}