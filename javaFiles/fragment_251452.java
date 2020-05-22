public void saveUsers(List<User> listOfUsers){
    Observable.from(listOfUsers).flatMap((User user)->{
         if(user.isValid()){
           save(user);
           //Set result ok
           return Observable.just(result);
         }else
           return Observable.error(new RuntimeException("..."));
   }).retry(2);
}