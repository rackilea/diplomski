@Component
@Aspect
public class TenantAspect {

    private final
    TenantStore tenantStore;

    @Autowired
    public TenantAspect(TenantStore tenantStore) {
        this.tenantStore = tenantStore;
    }

    @Around(value = "execution(* com.things.stuff.controller..*(..))")
    public Object assignForController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return assignTenant(proceedingJoinPoint);
    }

    private Object assignTenant(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (user != null) tenantStore.setTenantId(user.getSchool().getCode());
        } finally {
            Object retVal;
            retVal = proceedingJoinPoint.proceed();
            tenantStore.clear();
            return retVal;
        }
    }
}