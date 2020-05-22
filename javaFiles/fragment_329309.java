public class Validation {

    public static void main(String[] args) {  
       String pass = "1AB%CDef555";
       String username = "manna";
       String email = "mannx@rtt.com";
       System.out.println(validiate2(pass, username,email));
    }
    // if you don't care why it fails and only want to know if valid or not 
    public static boolean validiate (String pass, String username, String email){
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";
        if(pass.matches(pattern)){
            for(int i=0;(i+3)<username.length();i++){
                if(pass.contains(username.substring(i,i+3)) || username.length()<3 || username.length()>15){
                   return false; 
                }                  
            }
            for(int i=0;(i+3)<email.length();i++){
                if(pass.contains(email.substring(i,i+3)) || email.length()<3 || email.length()>15){
                   return false; 
                }                  
            }
            return true;
        }
        return false;    
    }
    // if you want to know which requirement was not met
    public static boolean validiate2 (String pass, String username, String email){
        if (pass.length() < 8 || pass.length() >15 ){
            System.out.println("pass too short or too long");
            return false;
        }
        if (username.length() < 3 || username.length() >15 ){
            System.out.println("username too short or too long");
            return false;
        }
        if (!pass.matches(".*\\d.*")){
            System.out.println("no digits found");
            return false;
        } 

        if (!pass.matches(".*[a-z].*")) {
            System.out.println("no lowercase letters found");
            return false; 
        }
        if (!pass.matches(".*[!@#$%^&*+=?-].*")) {
            System.out.println("no special chars found");
            return false; 
        } 
        if (containsPartOf(pass,username)) {
            System.out.println("pass contains substring of username");
            return false; 
        }
        if (containsPartOf(pass,email)) {
            System.out.println("pass contains substring of email");
            return false; 
        }
        return true;           
    }

    private static boolean containsPartOf(String pass, String username) {
        int requiredMin = 3
        for(int i=0;(i+requiredMin)<username.length();i++){
            if(pass.contains(username.substring(i,i+requiredMin))){
               return true; 
            }                  
        }
        return false;        
    }    
}