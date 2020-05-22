@RequestMapping("/my_test")
public String my_test(HttpServletResponse response) {
  String result;
  ...processing...
  response.setContentType("text/plain");
  response.setCharacterEncoding("UTF-8");
  return result ;
}