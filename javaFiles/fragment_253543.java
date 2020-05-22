@Aspect
@Component
@EnableAspectJAutoProxy
public class WriteTransactionAspectBean {

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void test(org.springframework.transaction.annotation.Transactional t) {
        System.out.println("TEST");
    }

}