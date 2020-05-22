doFilter() {

    // if its a first request:
     if(httpSessionIsCreatedInThisRequest() && noFirstLoginTimeOnSession()) {
         httpSession.put("FIRST_LOGIN_TIME", getCurrentTime())
     }
     else { // for any subsequent request
      currentTime = getCurrentTime()

      if(currentTime - getFromSession("FIRST_LOGIN_TIME") < 10 mins) {
         // you can proceed
      } 
      else {
          logout()
         //do whatever You Need Here: logout, destroy the session
      }
     }
  }