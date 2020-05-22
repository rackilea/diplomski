@RequestMapping(value="/adminvalidate")
public ModelAndView validateAdmin(@RequestParam(value="userid",required=true) String userid, @RequestParam(value="password",required=true) String password) {
            String result = loginser.validate(userid, password);
    if (result.equals("pass")) {
        return new ModelAndView("redirect:admin/view");
    }
    return new ModelAndView("error");
}