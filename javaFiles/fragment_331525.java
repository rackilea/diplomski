@Controller
 public class Controller{

 @RequestMapping(value = "service/getData", method = RequestMethod.POST)
 @ResponseBody
 public ResponseEntity<Any> getData(@RequestBody JsonNode jsonNode){

   ObjectMapper obj = new ObjectMapper();

  if(jsonNode.has("name"){
   Option1 result= obj.convertValue(jsonNode,Option1.class)
  return ResponseEntity<Any>(result.name,HttpStatus.OK)
    }    

   else {

   Option2 result= obj.convertValue(jsonNode,Option2.class)
   return ResponseEntity<Any>(result.id,HttpStatus.OK)
    }

    return ResponseEntity<Any>("ok",HttpStatus.OK)
     }