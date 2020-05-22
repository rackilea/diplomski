@RequestMapping("/test")
public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = request.getScheme() + "://" + 
                 request.getServerName() + ":" + 
                 request.getServerPort() + 
                 request.getContextPath() + "/path/to/resource";
    response.sendRedirect(url);
}