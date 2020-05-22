JSONObject jsonObject = JSONObject.fromObject( responseDTO );  
/*  
  jsonStr is something like below, "errors" represents the List<ObjectError>
  I don't know what's in ObjectError, errorName is just an example property.
  {
    "dataRequestName":"request1",
    "actionPassed":true,
    "errors":[{"errorName":"error"},{"errorName":"unknown error"}]
  } 
*/
String jsonStr = jsonObject.toString();
model.addAttribute("dataJson", jsonStr);  

/*In JSP, get the corresponding javascript object
 by eval the json string directly.*/
<script>
var data = eval('('+'${dataJson}'+')'); 
</script>