class MyController {
   @RequestMapping("/sub")
   public String someMethod(@ModelAttribute Params params, BindingResult result){
       if(result.hasErrors()){
          return "error";
       }

       //do operation with params.value
       return "view";

   }

    public static class Params {
        // add eventual JSR-303 annotations here
        String value;

       // getter and setter ommited for brievety
    }

}