@RequestMapping(value=("login"),method=RequestMethod.POST)
public String login(@RequestParam("name")String name,@RequestParam("pass")String pass,@RequestParam("gName")String gName,HttpSession session
        ) {

    User u1=new User();
    u1.setName(name);
    u1.setgName(gName);
    u1.setPass(pass);
    User u2=dao.findById(name);
    if(u2!=null)
    { if(u1.getPass().equals(u2.getPass())&&u1.getgName().equals(u2.getgName()))
        {

            session.setAttribute("user", u1);
            return "welcome";
        }
        else
        {
            return "error";
        }
    }
    else
    {
        return "error";
    }


}