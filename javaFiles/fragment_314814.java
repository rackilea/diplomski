public static boolean check_non_string_value (String First_name, String Last_name){
   if(First_name.matches("\\w")&&Last_name.matches("\\w")){
          system.out.println("Valid input");
        return true;
   }
   return false;
}