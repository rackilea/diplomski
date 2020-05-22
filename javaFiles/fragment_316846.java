public void validateLogin() {    
   //This is for login action   
   if(login == null) {
     addActionError("Login is null"); 
   } else            
   if("foobar".equals(login.getPassword()){
     addActionMessage(SUCCESS); 
   } else {
     addFieldError("Password", "Password should be greater then 6"); 
   }   
 }   


 public void validateRegister() {
   //This is for registration action
   if(user == null) {  
     addActionError("User is null"); 
   } else            
   if(user.getPassword() == null || user.getPassword().length() < 6) {
     addFieldError("Password", "Password should be greater then 6"); 
   } 

 }