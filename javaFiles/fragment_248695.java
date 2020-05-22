public String myControllerMethod(ModelMap myModel) {
   myModel.put(...);
   if (Math.random()<0.5) {
     throws new RuntimeException("only a example");
   }
}