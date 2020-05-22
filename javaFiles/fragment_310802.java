@RequestMapping(value="/loginSubmit",method=RequestMethod.POST)
public  @ResponseBody User loadUserByUsername(@RequestBody Map<String,Object> credentials, HttpSession session){
    String username = credentials.get("username");
    String password = credentials.get("password");
    System.out.println("controller");
    System.out.println("name is "+username);
    return null;
}