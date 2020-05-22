@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class MyFacadeEJB implements MyFacadeLocal {
// automatically injected with a matching Spring bean
@Autowired
private MyComponent myComp;
// for business method, delegate to POJO service impl.
public String myFacadeMethod(...) {
return myComp.myMethod(...);
}