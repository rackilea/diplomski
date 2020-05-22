try {
    LoginInfoAdmin admin = dao.getEmpById(uname);
    if(uname.equals(admin.getUsername()) && pwd.equals(admin.getPassword()) && dept.equals(admin.getDept()))
    {
        req.getSession().setAttribute("uname",admin.getName());
        if(dept.equals((String)admin.getDept())){
            return new ModelAndView("adminLoginResult", "message", message1); 
        }
        else if(dept.equals((String)admin.getDept())){
            return new ModelAndView("EmployeeLoginResult","message",message1);
        }
        else{
            return new ModelAndView("ManagerLoginResut","message",message1);
        }
    } 
    else
    {
        return new ModelAndView("forward:index.jsp","message","Sorry Username Password Error");
    }
} catch (EmptyResultDataAccessException erdae) {
    return new ModelAndView("forward:index.jsp","message","Sorry Username Password Error");
}