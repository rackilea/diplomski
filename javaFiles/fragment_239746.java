@Aspect
@Component
public class ObjectFromPoolAspect {
    private GenericObjectPool pool = new GenericObjectPool();

    @Around("within(org........HasObjectFromPool+) && @annotation(applyObjectFromPool))")
    public Object applyObjectFromPool(ProceedingJoinPoint point ,
                  ApplyObjectFromPool applyObjectFromPool) throws Throwable {
        Object result;
        HasObjectFromPool target = (HasObjectFromPool) point.getTarget();
        Object objectFromPool = pool.borrowObject();
        try {
            target.setObjectFromPool(objectFromPool);
            result = point.proceed();
        }finally {
            pool.returnObject(objectFromPool);
        }
        return result;
    }
}