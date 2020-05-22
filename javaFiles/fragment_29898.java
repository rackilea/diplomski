@RequestMapping(path ="/savekey", method = RequestMethod.POST)
String simpanKey(@RequestParam int company_id) {

 // your predefined logic
 // now it will be provided in the url without any request body

}

In this case, your url will be :
**http://111.111.1.111:0000/savekey?company_id=1**