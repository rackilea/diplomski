@Aspect()
public class DetermineCaseTypeOfWork {

@Transactional
@Around(@annotation("path goes here"))
public void insertThing(ProceedingJoinPoint joinPoint) throws Throwable {

// save initialized map to threadlocal    
VariableContextHolder.getInstance().set(new HashMap<>());

// method onEvent() will be called
joinPoint.proceed();

// retrieve map from threadlocal
Map<String, Object> variablesMap = VariableContextHolder.getInstance().get();

// get variables by names and handle them
String procInstId = variablesMap.get("procInstId");

// clear threadlocal after using it
VariableContextHolder.getInstance().clear();
}

}