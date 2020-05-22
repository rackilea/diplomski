public class ValidateIdService {
    public boolean isValid() {
        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
               .getRequest(); 
        String ipAddr = req.getRemoteAddr();
        // validate IP address
        if(valid)
           return true;
        else return false;
    }
}