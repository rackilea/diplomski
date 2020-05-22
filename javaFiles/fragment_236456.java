class EncouragementService {
   def encourageUsers(List<User> users){
       if(users){ //Groovy truth takes care of all the checks
          for(user in users){
            //logic
          }
       }   
   }
}