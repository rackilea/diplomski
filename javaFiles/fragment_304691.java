@RequestMapping(value = "/FileUpload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file,  HttpServletRequest request, HttpServletResponse response) throws IOException  {
     List<String> numbers = new ArrayList<String>();
     InputStream inputStream = file.getInputStream(); 
     BufferedReader bufferReader =   new BufferedReader(new InputStreamReader(inputStream));
     String numberLine;
     while ((numberLine = bufferReader.readLine()) != null) {
        numbers.add(numberLine);
     }
     bufferReader.close();
     /* pint all numbers */
     numbers.forEach(System.out::println):
     String result = String.join(",", numbers);
     return new ResponseEntity<String>(result, HttpStatus.OK);
}