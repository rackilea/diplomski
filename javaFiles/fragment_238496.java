@RequestMapping(..)
public void convertedImg(HttpServletResponse resp) {
  // set response Content-Type..
  OutputStream os = resp.getOutputStream();
  //.. write your converted image into os
}