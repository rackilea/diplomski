int a = Integer.parseInt(aTextField.getText()); 
                           // ^  text fields haven't yet initialized
int b = Integer.parseInt(bTextField.getText());
int c = Integer.parseInt(cTextField.getText());
int discriminant = (int)Math.pow((double)b, 2) - 4*a*c;
int x1 = (int)(-b + (double)Math.sqrt(discriminant) / 2*a);
int x2 = (int)(-b - (double)Math.sqrt(discriminant) / 2*a);

public DiscriminantSoft(){
///....... your code

   aTextField = new JTextField(3); // <---- you are initializing them here
   add(aTextField);
   bTextField = new JTextField(3);
   add(bTextField);
   cTextField = new JTextField(3);
    add(cTextField);
}