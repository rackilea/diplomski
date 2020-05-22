for(FileItem item : multiparts){
 if(!item.isFormField()){
   // the logic you already have now
 } else {
   if ("comment".equals(item.getFieldName())) {
        String comment = item.getString();
    // Whatever you have to do with the comment
   }
 }
}