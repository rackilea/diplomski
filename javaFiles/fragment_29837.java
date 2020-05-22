/** 
 * Constructor
*/ 
public SecurityInInterceptor() {
   super(Phase.PRE_PROTOCOL);
   getAfter().add(SAAJInInterceptor.class.getName());
}