private static NewAgentObj instance; //your static, reusable instance

public static NewAgentObj newInstance(){
   if (instance == null){ 
       instance = new NewAgentObj(); //only create the Object if it doesn't exist
   }
   return instance;