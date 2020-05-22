@RequestMapping(value = "/postback", params = "code", method = RequestMethod.GET)
@ResponseBody
private void accessCode(@RequestParam("code") String code,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        //Now the variable 'code' holds the authorization code
}