public static void main(String[] args)
{
   String propertyName = "sun.java2d.noddraw";
   System.setProperty(propertyName, "true");

   propertyName = "sun.java2d.d3d";
   System.setProperty(propertyName, "false");

   try 
   {
       javax.swing.UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
   }
   catch (Exception ex) 
   {
       ex.printStackTrace();
   }

   //YOUR CODE HERE...

}