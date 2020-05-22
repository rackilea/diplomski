@Override
protected void doSetFocus()
{
  super.doSetFocus();

  if (text != null) {
     text.setSelection(0, 0);
   }
}