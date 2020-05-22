public class UserList { 
    private boolean ok=true; 
    private User enterprise = null; 
    private List<User> teams = new ArrayList<>(); 

    { 
    enterprise=new User("Man","NYC"); 
    Icon icon = new Icon("www.google.com",true);
    enterprise.setIcon(icon);
    } 
 }