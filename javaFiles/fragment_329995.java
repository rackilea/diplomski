@RequestMapping(value="/create",
                method=RequestMethod.POST,
                consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public String createRole(@RequestBody MultiValueMap<String, String> formData){
 // your code goes here
}