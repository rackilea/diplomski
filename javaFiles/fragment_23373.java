public static void onlyPost() {
  if (request.method.equals("POST")) {
     // ... Do stuff
     render(); 
  }
  else
    forbidden();
}