private class TextAction extends FocusAdapter
{
   @Override
   public void focusGained(FocusEvent e) 
   { 
       responseTxt.setText("Got focus"); 
   } 
}