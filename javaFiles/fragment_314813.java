public static boolean check_non_string_value (String First_name, String Last_name){
   if(First_name.matches("[a-zA-Z]+")&&Last_name.matches("[a-zA-Z]+")){
          system.out.println("Valid input");
        return true;
   }
   return false;
}