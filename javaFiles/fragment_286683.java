public void performTweetCleanup(){
       //calculate date
       Calendar cal = Calendar.getInstance();
       Date today = cal.getTime();
       cal.add(Calendar.YEAR, -1);
       Date previousYear = cal.getTime();

       //call the method
       MyTweeterRepository.deleteByCreatedAtBefore(previousYear);
     }