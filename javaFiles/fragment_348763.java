try {
   Long result = helperObj.getSomething();
}
catch(Exception ex) {
  if (ex instanceOf ProfileException) {
      //Handle profile exception

  } else if (ex instanceOf UserException) {
     // Handle user exception

  }
}