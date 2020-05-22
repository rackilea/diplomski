boolean newColumn = true;
for(int i=1; i<=metaPatho.getColumnCount(); i++){
metaNomsDB=metaPatho.getColumnName(i);
   if (metaNomsDB.equals (nomDBFinal)){
     newColumn = false;
   }
}