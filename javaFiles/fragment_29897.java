@RequestMapping(path ="/savekey/{company_id}", method = RequestMethod.POST)
String simpanKey(@PathVariable int company_id) {

// your predefined logic
// now it will be provided in the url without any request body

}

In this case, your url will be :
**http://111.111.1.111:0000/savekey/1**