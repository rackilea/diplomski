double value;
String text =your_edittext.getText().toString();
if(!text.isEmpty())
try
{
   value= Double.parseDouble(text);
   // it means it is double
} catch (Exception e1) {
   // this means it is not double 
   e1.printStackTrace();
}