@RequestMapping(value="sendData" ,method = RequestMethod.POST)
public String add(HttpServletRequest request, ModelMap model) {

String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String email = request.getParameter("email");

System.out.println(email);
System.out.println(firstName);
System.out.println(lastName);

Customer c = new Customer();
c.setFirstName(firstName);
c.setLastName(lastName);
c.setEmail(email);
c.setDate(new Date());

PersistenceManager pm = PMF.get().getPersistenceManager();
try {
    pm.makePersistent(c);
} finally {
    pm.close();
}

return "successpage";
}