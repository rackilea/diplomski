import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.weaver.AnnotatedElement;

@Configuration
@ConditionalOnClass({ EnableAspectJAutoProxy.class, Aspect.class, Advice.class,
    AnnotatedElement.class })
@ConditionalOnProperty(prefix = "spring.aop", name = "auto", havingValue = "true", matchIfMissing = true)
public class AopAutoConfiguration {

  @Configuration
  @EnableAspectJAutoProxy(proxyTargetClass = false)
  @ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "false", matchIfMissing = false)
  public static class JdkDynamicAutoProxyConfiguration {

  }

  @Configuration
  @EnableAspectJAutoProxy(proxyTargetClass = true)
  @ConditionalOnProperty(prefix = "spring.aop", name = "proxy-target-class", havingValue = "true", matchIfMissing = true)
  public static class CglibAutoProxyConfiguration {

  }

}