//Retrieve Parameter (been send into the servlet from outside)
String login = req.getParameter("login");
if(null == login) {
  //Retrieve Attribute you put into the request in doGet()
  login = (String)req.getAttribute("login");
}