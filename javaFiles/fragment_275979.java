private void jButton1ActionPerformed (ActionEvent evt){
   // are you sure that this split returns the names? Maybe you should split by \\n
   String[] names = jTextArea1.getText().split("\\n");
   // build the text to set into textarea2
   String text = "";
   for(int i=0;i<names.length;i++)
   {
      text += "welcome "+names[i]+"\n";
   }

   jTextArea2.setText(text);
}