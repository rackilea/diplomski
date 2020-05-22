@RequestMapping(value="/admin/user/detail", method=RequestMethod.GET)
public @ResponseBody MMUser userDetail(HttpServletRequest request, 
    HttpServletResponse response, @RequestParam("id") int id)
            throws IOException, JSONException, ServletException{
   MMUser user = iUserService.getUser(id);
   return user;
}