if(rootNode.path(key).isArray()){
//key is the field in the json that you might be looking for
for (final JsonNode objNode : rootNode) {

     for (Iterator<String> keyArray = objNode.getFieldNames(); keyArray.hasNext();){

         fieldName = keyArray.next();

         fieldValue = objNode.path(fieldName).asText();                 
         if(fieldValue != ""){
             System.out.println(fieldName + " = " + fieldValue);

         }else{
             arrayHandler(objNode,fieldName);
         }
     }
 }