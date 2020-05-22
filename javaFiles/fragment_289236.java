void someMethod(){
  int attempts = 0;
  while(attemps <= 3){
    try {
      sendMail(...);
      break;
    } catch (Exception e){
      attempts++;
      // Log failed to send mail or something meaningful, maybe add a delay here?
    } 
  }
}