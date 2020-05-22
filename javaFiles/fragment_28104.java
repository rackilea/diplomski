boolean executeCode = true; // boolean flag to decide
for(int i=0; i<ia.length; i++)  {
   tab=  ia[i].toString(); 
   if(query.contains(tab)) {
      JOptionPane.showMessageDialog(null,
                   "Owner does not have privileges to access given table");
      executeCode= false; // do not want to execute the rest of code
      break;
   }
}
if (executeCode) {
   //rest code
}