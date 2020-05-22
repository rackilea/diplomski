public class Jkl{
    public void executeAround(ProceedingJoinPoint pjp) {
       //certain validations
       if(isValid){
           // optionally enclose within try .. catch
           pjp.proceed();  // this line will invoke your advised method
       } else {
           // log something or do nothing
       }
    }
}