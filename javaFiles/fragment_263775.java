private static final long serialVersionUID = 1L;

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Service service = new Service(); 
            UserDetails userObj = new UserDetails();
            String action = request.getParameter("action");             
            Inbox inbox = new Inbox();

         if (action.equals("EDIT")) {   
             System.out.println("Edit in extended class");
                int userId = Integer.parseInt(request.getParameter("userId"));
                userObj = service.getUserById(userId);
                UserDetails user = getUserInfoFromRequest(request);

                if(!(userObj.getFirstName()).equals(user.getFirstName())) {
                     inbox.setMessage("Change of First Name from " +userObj.getFirstName() +" to " +user.getFirstName() +" for user " +userObj.getFirstName());
                     service.addToInbox(user.getUserId(), inbox.getMessage());
                }
                if(!(userObj.getLastName()).equals(user.getLastName())) {
                    inbox.setMessage("Change of Last Name from " +userObj.getLastName() +" to " +user.getLastName() +" for user " +userObj.getFirstName());
                    service.addToInbox(user.getUserId(), inbox.getMessage());
                }
                if(!(userObj.getEmail()).equals(user.getEmail())) {
                    inbox.setMessage("Change of Email from " +userObj.getEmail() +" to " +user.getEmail() +" for user " +userObj.getFirstName());
                    service.addToInbox(user.getUserId(), inbox.getMessage());
                }
                if(!(userObj.getUserName()).equals(user.getUserName())) {
                    inbox.setMessage("Change of Username from " +userObj.getUserName() +" to " +user.getUserName() +" for user " +userObj.getFirstName());
                    service.addToInbox(user.getUserId(), inbox.getMessage());
                }
                if(!(userObj.getPassword()).equals(user.getPassword())) {
                    inbox.setMessage("Change of Password from " +userObj.getPassword() +" to " +user.getPassword() +" for user " +userObj.getFirstName());
                    service.addToInbox(user.getUserId(), inbox.getMessage());
                }
                if((userObj.getDeptId()) != (user.getDeptId())) {
                    inbox.setMessage("Change of Department from " +userObj.getDeptName() +" for user " +userObj.getFirstName());
                    service.addToInbox(user.getUserId(), inbox.getMessage());
                } 

         }
   }
}