public static boolean f(boolean x, boolean y){

     switch(x + "-" + y){

        case "true-false": 
             return false; //i also tried "return x" or "return y"
        case "false-true": 
             return false;
        case "true-true": 
             return true;
        case "false-false": 
             return false; 
        default:
            return false;
      }

}