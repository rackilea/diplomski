public class CustomTextView extends TextView{
  // Overwrite any mandatory constructors and methods and just call super

  public void removeLastLine(){
    if(getText() == null) return;
    String currentValue = getText().toString();
    String newValue = currentValue.substring(0, currentValue.lastIndexOf("\n"));
    setText(newValue);
  }
}