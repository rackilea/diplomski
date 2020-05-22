@Component
@Aspect
public class TranslatorInterceptor extends AccessApiController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TranslationService translationService;

    @Pointcut("execution(* com.company.project.api.controller.*.get*(..))")
    public void petitionsStartWithGet() { }

    @Pointcut("execution(* com.company.project.api.controller.*.list*(..))")
    public void petitionsStartWithList() { }

    @Pointcut("execution(* com.company.project.api.controller.*.find*(..))")
    public void petitionsStartWithFind() { }

    @AfterReturning(pointcut = "petitionsStartWithGet() || petitionsStartWithList() || petitionsStartWithFind()", returning = "result")
    public void getNameAdvice(JoinPoint joinPoint, Object result){
        translationService.translate(result, getCustomUserDetails().getLanguageId());
        logger.debug("Translating " + result.getClass().toString());
    }
}