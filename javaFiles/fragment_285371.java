@Aspect
@Component
public class CommonAspect {


    @AfterReturning(value = "@annotation(audit) && execution(CommonEntity *(..))",returning="retVal")
    public void save(JoinPoint jp, CommonEntity retVal, Audit audit) {

        Audit auditInfo = new Audit();
        auditInfo.setMessage(retVal.getAuditMessage());
        //other code to store audit

    }


}