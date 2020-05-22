@RequestMapping("/some")
public Response some(@RequestParam(value="body")  String user,HttpServletResponse 
response) {
   response.addHeader("Access-Control-Allow-Origin", "*");
   return new Response(user);
}